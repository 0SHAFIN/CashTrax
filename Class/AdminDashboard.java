package Class;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.*;
import java.nio.file.*;

class AdminDashboard
{

  JFrame f= new JFrame();
  ImageIcon img1;
  JLabel l1,l2,l3,l4,l5,l6;
  JButton b1, b2,b3,b4,b5,b6,b7,b8,b9,b10;
  JTextField t1,t2,t3,t4;

  AdminDashboard()
  {

   Image icon = Toolkit.getDefaultToolkit().getImage(".\\image\\logo.png");
   f.setIconImage(icon);
    

    Font f1= new Font("Myriad Pro",Font.BOLD,18);
    Font f4= new Font("Roboto",Font.BOLD,22);
    Font f2= new Font("Myriad Pro",Font.BOLD,13);
    Font f3= new Font("Roboto",Font.BOLD,14);
    Font f5= new Font("Roboto",Font.BOLD,13);



    img1= new ImageIcon(".\\image\\admin.png");
    l1= new JLabel(img1);

 


    


    l3= new JLabel("ADMIN");
    l3.setFont(f4);
    l3.setForeground(Color.WHITE);
    l3.setBounds(100,35,200,20);
    f.add(l3);

    b1= new JButton("Search Account");
    b1.setFont(f5);
    b1.setForeground(Color.decode("#8F7F68"));
    b1.setBorder(BorderFactory.createEmptyBorder());
    b1.setBounds(270,25,100,20);
    f.add(b1);
    b1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
      b1.setVisible(false);
      t1.setVisible(true);
      b3.setVisible(true);
    }});
    
    t1= new JTextField();
    t1.setBounds(250,35,130,20);
    f.add(t1);
    t1.setVisible(false);

    b3= new JButton("Search");
    b3.setBorder(BorderFactory.createEmptyBorder());
    b3.setForeground(Color.WHITE);
    b3.setBackground(Color.decode("#F4682D"));
    b3.setBounds(285,60,75,20);
    b3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
     {
      
       String num= t1.getText();
       String number="Phone number :"+num;
       if(num.isEmpty())
      {
         JOptionPane.showMessageDialog(null,"Enter Your Number ", "Search Info", JOptionPane.WARNING_MESSAGE);
        
      }
      else 
      {
        try
        {
          FileReader fr=new FileReader(".\\data\\user_info.txt");
          BufferedReader read= new BufferedReader(fr);
          int cnt=0;
          while(read.readLine()!=null)
            {
               cnt++;
            }
            read.close();
            int n=0;
            for(int i=0;i<cnt;i++)
            {
              String line1=Files.readAllLines(Paths.get(".\\data\\user_info.txt")).get(i);
               if(line1.equals(number))
                 {
                   JOptionPane.showMessageDialog(null,"Account Successfully found ", "Search Info", 2);
                   n++;
                   break;
                 }
                 else 
                 {
                  n=0;
                 }
            }
            if(n==0)
            {
              JOptionPane.showMessageDialog(null,"Account not available. ", "Search Info", 2);       
            }
        }
        catch(Exception ex)
        {
          System.out.println(ex);
        }
      }
      } 
     }
   );
    f.add(b3);
    b3.setVisible(false);


    

    b2 =new JButton("Add Account");
    b2.setFont(f3);
    b2.setForeground(Color.WHITE);
    b2.setBackground(Color.decode("#8F7F68"));
    b2.setBorder(BorderFactory.createEmptyBorder());
    b2.setBounds(40,120,150,35);
    b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ea)
    {
      f.setVisible(false);
      new Addaccount();
    }
    
    });
    f.add(b2);




    b5=new JButton("Logout");
    b5.setFont(f3);
    b5.setForeground(Color.WHITE);
    b5.setBackground(Color.decode("#8F7F68"));
    b5.setBorder(BorderFactory.createEmptyBorder());
    b5.setBounds(245,410,90,30);
    b5.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ed)
    {
      f.setVisible(false);
      new Adminlogin();
      
    }
    
    });
    f.add(b5);




    b6=new JButton("Exit");
    b6.setFont(f3);
    b6.setForeground(Color.WHITE);
    b6.setBackground(Color.decode("#8F7F68"));
    b6.setBorder(BorderFactory.createEmptyBorder());
    b6.setBounds(40,410,90,30);
    b6.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ef)
    {
      System.exit(0);
    }
    
    });
    f.add(b6);


    b9= new JButton("User Info");
    b9.setFont(f3);
    b9.setForeground(Color.WHITE);
    b9.setBackground(Color.decode("#8F7F68"));
    b9.setBorder(BorderFactory.createEmptyBorder());
    b9.setBounds(200,120,150,35);
    f.add(b9);
    b9.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        f.setVisible(false);
        new UserInfo();
      }
    });

   f.add(l1);
   f.setSize(400,500);
   f.setTitle("Admin Dashboard");
   //f.setLayout(null);
   f.setLocationRelativeTo(null);

   f.setVisible(true);

  }

  public static void main(String[]args)
  {
    new AdminDashboard();
  }
   
   }