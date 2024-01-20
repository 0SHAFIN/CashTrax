package Class;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.*;
import java.nio.file.*;

class Addmoney 
{


    double balance,amount,eq;
    String eqstr;

    JFrame f= new JFrame();
    ImageIcon img;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t5;
    JPasswordField t3,t4;
    JButton b1,b2,b3;

    Font f1= new Font("Roboto",Font.BOLD,14);
    Font f2= new Font("Couture",Font.BOLD,15);
    Font f3= new Font("Robot",Font.BOLD,12);

	  Addmoney()
	{
        Image icon = Toolkit.getDefaultToolkit().getImage(".\\image\\logo.png");
        f.setIconImage(icon);
        f.setTitle("CashTrax");

         img= new ImageIcon(".\\image\\add.png");
         l1= new JLabel(img);

         l4= new JLabel("ADD MONEY");
         l4.setForeground(Color.decode("#F4682D"));
         l4.setBounds(144,75,110,20);
         l4.setFont(f2);
         f.add(l4);

         l2=new JLabel("Number : ");
         l2.setFont(f3);
         l2.setForeground(Color.decode("#8F7F68"));
         l2.setBounds(60,100,100,20);
         f.add(l2);

         t1= new JTextField();
         t1.setForeground(Color.decode("#8F7F68"));
         t1.setBounds(150,100,140,25);
         f.add(t1);

         l7=new JLabel("Card Number : ");
         l7.setFont(f3);
         l7.setForeground(Color.decode("#8F7F68"));
         l7.setBounds(60,130,100,20);
         f.add(l7);

         t5= new JTextField();
         t5.setForeground(Color.decode("#8F7F68"));
         t5.setBounds(150,130,140,25);
         f.add(t5);


         l3= new JLabel("Amount :");
         l3.setFont(f3);
         l3.setForeground(Color.decode("#8F7F68"));
         l3.setBounds(60,160,70,20);
         f.add(l3);

         t2= new JTextField();
         t2.setForeground(Color.decode("#8F7F68"));
         t2.setBounds(150,160,140,25);
         f.add(t2);

         l5= new JLabel("Card PIN :");
         l5.setFont(f3);
         l5.setForeground(Color.decode("#8F7F68"));
         l5.setBounds(60,190,110,20);
         f.add(l5);


         t3= new JPasswordField();
         t3.setForeground(Color.decode("#8F7F68"));
         t3.setBounds(150,190,140,25);
         f.add(t3);



         l6= new JLabel("CashTrax PIN :");
         l6.setFont(f3);
         l6.setForeground(Color.decode("#8F7F68"));
         l6.setBounds(60,220,110,20);
         f.add(l6);


         t4= new JPasswordField();
         t4.setForeground(Color.decode("#8F7F68"));
         t4.setBounds(150,220,140,25);
         f.add(t4);


         b1= new JButton("Add");
         b1.setFont(f3);
         b1.setBorder(BorderFactory.createEmptyBorder());
         b1.setForeground(Color.WHITE);
         b1.setBackground(Color.decode("#F4682D"));
         b1.setBounds(210,260,80,30);
         b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               String number=t1.getText();
               String numbers="Phone number :"+number;
               String amounts=t2.getText();
               String textfild1=t3.getText();
               String textfild2=t4.getText();
               String textfild3=t5.getText();
               amount=Double.parseDouble(amounts);

               String balances;
               
               if(number.isEmpty() || amounts.isEmpty() || textfild1.isEmpty() ||textfild2.isEmpty()||textfild3.isEmpty())
               {
                  JOptionPane.showMessageDialog(null,"Please fill out all the informations.","Warning!",JOptionPane.WARNING_MESSAGE);
               }
               else 
               {
                  if(amount<0)
                {
                  JOptionPane.showMessageDialog(null,"Invalid amount.","Warning!",JOptionPane.WARNING_MESSAGE);
                }
                else 
                {
                  try
                  {
                  FileReader fr2=new FileReader(".\\data\\user_balance.txt");
                  BufferedReader read2= new BufferedReader(fr2);
                  int cnt2=0;
                  while(read2.readLine()!=null)
                   {
                     cnt2++;
                    }
                   read2.close();
                   int n=0;
                     for(int j=0;j<cnt2;j++)
                       {
                          String line3=Files.readAllLines(Paths.get(".\\data\\user_balance.txt")).get(j);
                           if(line3.equals(numbers))
                                {
                                    balances=Files.readAllLines(Paths.get(".\\data\\user_balance.txt")).get((j+1));
                                    balance=Double.parseDouble(balances.substring(9));
                                    eq=balance+amount;
                                    eqstr=String.valueOf(eq);
                                    n++;
                                    f.setVisible(false);
                                    new addmoneyalrt(eqstr);
                                    break; 
                                }

                        }
                        if(n==0)
                        {
                          JOptionPane.showMessageDialog(null,"Number not available.","Warning!",JOptionPane.WARNING_MESSAGE);
                        }
                           
                          
                     }
                     catch(Exception ex)
                     {
                        System.out.println(ex);
                     }
                }
               }
            }
         });
         f.add(b1);


         b2= new JButton("Previous");
         b2.setFont(f3);
         b2.setBorder(BorderFactory.createEmptyBorder());
         b2.setForeground(Color.WHITE);
         b2.setBackground(Color.decode("#F4682D"));
         b2.setBounds(50,320,90,30);
         f.add(b2);
         b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            f.setVisible(false);
            new Login();
             
           }
         });


         b3= new JButton("Close");
         b3.setFont(f3);
         b3.setBorder(BorderFactory.createEmptyBorder());
         b3.setForeground(Color.WHITE);
         b3.setBackground(Color.decode("#F4682D"));
         b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            System.exit(0);
            }
         });
         b3.setBounds(250,320,90,30);
         f.add(b3);

         f.add(l1);
         f.setSize(400,400);
         f.setLocationRelativeTo(null);
         f.setVisible(true);
	}

   

	public static void main(String[]args)
	{
		new Addmoney();
	}
}