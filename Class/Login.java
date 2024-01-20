package Class;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.*;
import java.nio.file.*;

public class Login
{

	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6;
    JButton b1,b2,b3,b4;
    JTextField t1; JPasswordField pass;
    JSeparator j1,j2;
    ImageIcon img,img1,img2;
    JComboBox box;


    Font f1= new Font("Roboto",Font.BOLD,15);
    Font f2= new Font("Couture",Font.BOLD,25);
    Font f3= new Font("Robot",Font.BOLD,11);
    Font f4= new Font("Roboto",Font.BOLD,13);


    

   
	public Login()
	{



     f= new JFrame();
  
     Image icon = Toolkit.getDefaultToolkit().getImage(".\\image\\logo.png");
     f.setIconImage(icon);
     f.setTitle("CashTrax");
      
     img= new ImageIcon("rsz_download_1.png");
     l4= new JLabel(img);
     l4.setBounds(130,6,img.getIconWidth(),img.getIconHeight());
     //f.add(l4);

     img1= new ImageIcon(".\\image\\BG.png");
     l6= new JLabel(img1);
     
     String cnt[]= {"Eng","Ban","Ind"};
     box= new JComboBox(cnt);
     box.setBounds(5,5,55,20);
     box.setBackground(Color.WHITE);
     f.add(box);

     b4= new JButton("Admin Login");
     b4.setBorder(BorderFactory.createEmptyBorder());
     b4.setForeground(Color.WHITE);
     b4.setBackground(Color.decode("#F4682D"));
     b4.setBounds(273,3,105,25);
     b4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            f.setVisible(false);
            new Adminlogin();
        }
     });
     f.add(b4);
     

     j1=new JSeparator();
     j1.setBounds(130,200,167,30);
     j1.setBackground(Color.BLACK);
     //f.add(j1);
      
     l1= new JLabel("Welcome");
     l1.setFont(f1);
     l1.setForeground(Color.decode("#8F7F68"));
     l1.setBounds(95,100,70,30);
     f.add(l1);

     l2= new JLabel("Login");
     l2.setFont(f2);
     l2.setForeground(Color.decode("#F4682D"));
     l2.setBounds(95,130,160,30);
     f.add(l2);

     l3= new JLabel("to your CashTrax account");
     l3.setForeground(Color.decode("#8F7F68"));
     l3.setFont(f3);
     l3.setBounds(95,145,150,30);
     f.add(l3);


     l4= new JLabel("Username : ");
     l4.setForeground(Color.decode("#8F7F68"));
     l4.setFont(f1);
     l4.setBounds(95,190,120,30);
     f.add(l4);

     t1= new JTextField();
     t1.setFont(f4);
     t1.setForeground(Color.decode("#8F7F68"));
     t1.setBorder(BorderFactory.createEmptyBorder());
     JSeparator s1 = new JSeparator();
     s1.setBounds(95,235,190,10);
     s1.setForeground(Color.decode("#8F7F68"));
     f.add(s1);
     t1.setBounds(95,210,190,25);
     f.add(t1);


     l5= new JLabel("CashTrax PIN :");
     l5.setForeground(Color.decode("#8F7F68"));
     l5.setFont(f1);
     l5.setBounds(95,240,150,20);
     f.add(l5);


     pass= new JPasswordField();
     pass.setFont(f4);
     pass.setEchoChar('*');
     pass.setForeground(Color.decode("#8F7F68"));
     pass.setBorder(BorderFactory.createEmptyBorder());
     JSeparator s = new JSeparator();
     s.setForeground(Color.decode("#8F7F68"));
     s.setBounds(95,280,190,10);
     f.add(s);
     pass.setBounds(95,260,190,20);
     f.add(pass);

    

     b1= new JButton("Login");
     b1.setFont(f1);
     b1.setBorder(BorderFactory.createEmptyBorder());
     b1.setForeground(Color.WHITE);
     b1.setBackground(Color.decode("#F4682D"));
     b1.setBounds(130,310,100,27);
     f.add(b1);


     b2= new JButton("Forgot PIN?");
     b2.setBorder(BorderFactory.createEmptyBorder());
     b2.setForeground(Color.WHITE);
     b2.setBackground(Color.decode("#8F7F68"));
     b2.setBounds(145,350,75,20);
     f.add(b2);

     b3= new JButton("Don't have any account? Create Account");
     b3.setBackground(Color.decode("#F4682D"));
     b3.setForeground(Color.WHITE);
     b3.setBorder(BorderFactory.createEmptyBorder());
     b3.setBounds(66,420,250,27);
     f.add(b3);



     b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               String user= t1.getText();
               String pas= pass.getText();
               String userName="User Name :" +user;
               String password="Password :" +pas;

               if(user.isEmpty()||pas.isEmpty())
               {
                JOptionPane.showMessageDialog(null,"Please fill out all then information","Warning!",JOptionPane.WARNING_MESSAGE);
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
                    if(line1.equals(userName))
                    {
                        String line2=Files.readAllLines(Paths.get(".\\data\\user_info.txt")).get((i+1));                        
                        n++;
                        if(line2.equals(password))
                        {
                            String name=Files.readAllLines(Paths.get(".\\data\\user_info.txt")).get((i+2));
                            String number=Files.readAllLines(Paths.get(".\\data\\user_info.txt")).get((i+3));
                            String email=Files.readAllLines(Paths.get(".\\data\\user_info.txt")).get((i+4));
                            n++;

                             FileReader fr2=new FileReader(".\\data\\user_balance.txt");
                             BufferedReader read2= new BufferedReader(fr2);
                             int cnt2=0;
                             while(read2.readLine()!=null)
                             {
                               cnt2++;
                             }
                               read.close();
                               for(int j=0;j<cnt2;j++)
                                 {
                                   String line3=Files.readAllLines(Paths.get(".\\data\\user_balance.txt")).get(j);
                                   if(line3.equals(number))
                                   {
                                      String balance=Files.readAllLines(Paths.get(".\\data\\user_balance.txt")).get((j+1));
                                      f.setVisible(false);
                                      new UserDashboard(name.substring(11),number.substring(14),balance.substring(9));
 
                                   }

                                 }
                        }
                       
                    }
                   
                   }
                   if(n==0)
                   {
                      JOptionPane.showMessageDialog(null,"Please enter valid Username.","Warning!",JOptionPane.WARNING_MESSAGE);
                   }
                   else if(n==1)
                   {
                      JOptionPane.showMessageDialog(null,"Please enter valid Password.","Warning!",JOptionPane.WARNING_MESSAGE);

                   }

                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
               }
        
        
            }
        });


     b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

     b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Signup();
          f.setVisible(false);
            }
        });

     


     f.add(l6);

     f.getContentPane().setBackground(Color.WHITE);
     f.setSize(400,500);
     //f.setLayout(null);
     f.setLocationRelativeTo(null);
     f.setVisible(true);
	}
    

    public static void main(String[ ]args)
    {
        new Login();
    }
}