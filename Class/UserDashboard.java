package Class;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class UserDashboard
{
  private String name;
  private String number;
  private String balance;


	JFrame df= new JFrame();
	ImageIcon img1;
  JLabel l1,l2,l3,l4,l5;
  JButton b1, b2,b3,b4,b5,b6;
  JTextField t1;
  JTextArea text;

	UserDashboard()
  {
    
  }

    UserDashboard(String name, String number,String balance)
  {
    this.name=name;
    this.number=number;
    this.balance=balance;

     Image icon = Toolkit.getDefaultToolkit().getImage(".\\image\\logo.png");
     df.setIconImage(icon);
     df.setTitle("CashTrax");

    Font f1= new Font("Myriad Pro",Font.BOLD,18);
    Font f2= new Font("Myriad Pro",Font.BOLD,13);
    Font f3= new Font("Roboto",Font.BOLD,14);


    img1= new ImageIcon(".\\image\\sdashbord.png");
    l1= new JLabel(img1);

 


    l2 =new JLabel(number);
    l2.setFont(f3);
    l2.setForeground(Color.WHITE);
    l2.setBounds(90,48,100,20);
    df.add(l2);


    l3= new JLabel(name);
    l3.setFont(f1);
    l3.setForeground(Color.WHITE);
    l3.setBounds(90,25,200,20);
    df.add(l3);

    l5= new JLabel(balance);
    l5.setFont(f2);
    //t1.setBorder(BorderFactory.createEmptyBorder());
    l5.setForeground(Color.WHITE);
    l5.setBackground(Color.WHITE);
    //t1.setHorizontalAlignment(JTextField.CENTER);
    l5.setBounds(310,50,80,20);
    l5.setVisible(false);
    df.add(l5);

    b1= new JButton("Balance");
    b1.setForeground(Color.decode("#F4682D"));
    b1.setBorder(BorderFactory.createEmptyBorder());
    b1.setBounds(290,25,80,20);
    df.add(b1);
    b1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
      b1.setVisible(false);
      l5.setVisible(true);
    }});
    

    b2 =new JButton("Send Money");
    b2.setForeground(Color.WHITE);
    b2.setBackground(Color.decode("#F4682D"));
    b2.setBorder(BorderFactory.createEmptyBorder());
    b2.setBounds(40,120,150,35);
    b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ea)
    {
      df.setVisible(false);
      new Sendmoney();
      
    }
    
    });
    df.add(b2);

    
    b4=new JButton("Add Money");
    b4.setForeground(Color.WHITE);
    b4.setBackground(Color.decode("#F4682D"));
    b4.setBorder(BorderFactory.createEmptyBorder());
    b4.setBounds(200,120,150,35);
    b4.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ea)
    {
      df.setVisible(false);
      new Addmoney();
      
    }
    
    });
    df.add(b4);




    b5=new JButton("Logout");
    b5.setForeground(Color.WHITE);
    b5.setBackground(Color.decode("#F4682D"));
    b5.setBorder(BorderFactory.createEmptyBorder());
    b5.setBounds(50,410,90,30);
    b5.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ed)
    {
      df.setVisible(false);
      new Login();
      
    }
    
    });
    df.add(b5);




    b6=new JButton("Exit");
    b6.setForeground(Color.WHITE);
    b6.setBackground(Color.decode("#F4682D"));
    b6.setBorder(BorderFactory.createEmptyBorder());
    b6.setBounds(245,410,90,30);
    b6.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ef)
    {
      System.exit(0);
    }
    
    });
    df.add(b6);
  


   df.add(l1);
   df.setSize(400,500);
   //f.setLayout(null);
   df.setLocationRelativeTo(null);

   df.setVisible(true);

  }


  public static void main(String[]args)
  {
    new UserDashboard("shafin","123131","231");
  }
   
 }

