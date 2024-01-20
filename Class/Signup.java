package Class;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.*;
import java.util.*;
class Signup
{
    

	JFrame f=new JFrame("Signup");
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	ImageIcon img;
	JButton b1,b2;
	JSeparator j1,j2,j3,j4,j5;
	JPasswordField pass;
	JCheckBox c1;

    Font f2= new Font("Roboto",Font.BOLD,18);
    Font f1= new Font("Roboto",Font.BOLD,13);



	Signup()
	{
     Image icon = Toolkit.getDefaultToolkit().getImage(".\\image\\logo.png");
        f.setIconImage(icon);
        f.setTitle("CashTrax");

     img= new ImageIcon(".\\image\\BG.png");
     l1= new JLabel(img);
     
     l2= new JLabel("Sign Up");
     l2.setFont(f2);
     l2.setForeground(Color.decode("#F4682D"));
     l2.setBounds(70,80,70,30);
     f.add(l2);

     l3= new JLabel("Please fill in this form to create an account!");
     l3.setFont(f1);
     l3.setForeground(Color.decode("#8F7F68"));
     l3.setBounds(70,110,300,20);
     f.add(l3);


     l4= new JLabel("Full Name: ");
     l4.setForeground(Color.decode("#8F7F68"));
     l4.setFont(f1);
     l4.setBounds(70,130,100,20);
     f.add(l4);

     t1= new JTextField();
     t1.setForeground(Color.decode("#8F7F68"));
     t1.setBorder(BorderFactory.createEmptyBorder());
     t1.setBounds(70,150,240,20);
     f.add(t1);

     j1=new JSeparator();
     j1.setForeground(Color.decode("#8F7F68"));
     j1.setBounds(70,170,240,30);
     f.add(j1);


     l5= new JLabel("Number: ");
     l5.setForeground(Color.decode("#8F7F68"));
     l5.setFont(f1);
     l5.setBounds(70,180,100,20);
     f.add(l5);

     t2= new JTextField();
     t2.setForeground(Color.decode("#8F7F68"));
     t2.setBorder(BorderFactory.createEmptyBorder());
     t2.setBounds(70,200,240,20);
     f.add(t2);

     j2=new JSeparator();
     j2.setForeground(Color.decode("#8F7F68"));
     j2.setBounds(70,220,240,15);
     f.add(j2);


     l6= new JLabel("Email: ");
     l6.setForeground(Color.decode("#8F7F68"));
     l6.setFont(f1);    
     l6.setBounds(70,230,100,20);
     f.add(l6);

     t3= new JTextField();
     t3.setForeground(Color.decode("#8F7F68"));
     t3.setBorder(BorderFactory.createEmptyBorder());
     t3.setBounds(70,250,240,20);
     f.add(t3);

     j3=new JSeparator();
     j3.setForeground(Color.decode("#8F7F68"));
     j3.setBounds(70,270,240,15);
     f.add(j3);


     l7= new JLabel("Password: ");
     l7.setForeground(Color.decode("#8F7F68"));
     l7.setFont(f1);
     l7.setBounds(70,280,100,20);
     f.add(l7);

     pass= new JPasswordField();
     pass.setForeground(Color.decode("#8F7F68"));
     pass.setBorder(BorderFactory.createEmptyBorder());
     pass.setBounds(70,300,240,20);
     f.add(pass);

     j4=new JSeparator();
     j4.setForeground(Color.decode("#8F7F68"));   
     j4.setBounds(70,320,240,15);
     f.add(j4);



     l8= new JLabel("Username: ");
     l8.setForeground(Color.decode("#8F7F68"));
     l8.setFont(f1);
     l8.setBounds(70,330,100,20);
     f.add(l8);

     t5= new JTextField();
     t5.setForeground(Color.decode("#8F7F68"));    
     t5.setBorder(BorderFactory.createEmptyBorder());
     t5.setBounds(70,350,240,20);
     f.add(t5);

     j5=new JSeparator();
     j5.setForeground(Color.decode("#8F7F68"));    
     j5.setBounds(70,370,240,15);
     f.add(j5);



     c1= new JCheckBox("I agree to the terms and privacy policy.");
     c1.setForeground(Color.decode("#8F7F68"));    
     c1.setOpaque(false);
     c1.setContentAreaFilled(false);
     c1.setBorderPainted(false);
     c1.setBounds(70,375,250,30);
     f.add(c1);


     b2= new JButton("Pervious");
     b2.setBorder(BorderFactory.createEmptyBorder());
     b2.setForeground(Color.WHITE);
     b2.setBackground(Color.decode("#F4682D"));
     b2.setBounds(230,405,80,30);
     b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            f.setVisible(false);
            new Login();
        }
     });
     f.add(b2);
     

     

     b1= new JButton("Signup");
     b1.setBorder(BorderFactory.createEmptyBorder());
     b1.setForeground(Color.WHITE);
     b1.setBackground(Color.decode("#F4682D"));
     b1.setBounds(70,405,90,30);
     b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            String username=t5.getText();
            String password=pass.getText();
            String name=t1.getText();
            String number=t2.getText();
            String email=t3.getText();
            String balance ="5000";

                        try {
                            File file = new File(".\\data\\user_info.txt");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                        }
                            
                          catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        try 
                        {
                            FileWriter writer = new FileWriter(".\\data\\user_info.txt",true);
                            PrintWriter pr1 = new PrintWriter(writer);
                            pr1.println("User Name :" + username);
                            pr1.println("Password :" + password);
                            pr1.println("Full Name :" + name);
                            pr1.println("Phone number :" + number);
                            pr1.println("Email :" + email);
                            pr1.println("*****************************************");
                            pr1.close();

                        }
                        catch(IOException ex)
                        {
                            System.out.println(ex);
                        }

                        try {
                            File file2 = new File(".\\data\\user_balance.txt");
                            if (!file2.exists()) {
                                file2.createNewFile();
                            }
                        }
                            
                          catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        try 
                        {
                            FileWriter writer2 = new FileWriter(".\\data\\user_balance.txt",true);
                            PrintWriter pr2 = new PrintWriter(writer2);
                            pr2.println("Phone number :" + number);
                            pr2.println("Balance :"+ balance );
                            pr2.println("*****************************************");
                            pr2.close();

                        }
                        catch(IOException ex)
                        {
                            System.out.println(ex);
                        }


                        JOptionPane.showMessageDialog(null,"Signup succesfully done!","Signup",2);
                        f.setVisible(false);
                        new UserDashboard(name,number,balance);
                        
                    
                }
     });
     f.add(b1);



     f.add(l1);
     f.setSize(400,500);
     f.setLocationRelativeTo(null);
     f.setVisible(true);

	}

      public static void main(String[]args)
    {
        new Signup();
    }

 }


   


