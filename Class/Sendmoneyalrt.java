package Class;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Sendmoneyalrt
{
	String balances; 

  Font f1= new Font("Couture",Font.BOLD,25);
  Font f2= new Font("Roboto",Font.BOLD,17);
  Font f3= new Font("Roboto",Font.BOLD,14);
  ImageIcon img;

	JFrame f= new JFrame();
	JLabel l1,l2,l3,l4,l5;
	 Sendmoneyalrt(String balance)
     {
      Image icon = Toolkit.getDefaultToolkit().getImage(".\\image\\logo.png");
        f.setIconImage(icon);
        f.setTitle("CashTrax");
      
      //balances =String.valueOf(balance);

      img= new ImageIcon(".\\image\\Send.png");
      l4=new JLabel(img);


      l1= new JLabel("New Balance :");
      l1.setForeground(Color.decode("#8F7F68"));
      l1.setFont(f3);
      l1.setBounds(50,140,100,20);
      f.add(l1);

      l3= new JLabel("Sendmoney ");
      l3.setForeground(Color.decode("#F4682D"));
      l3.setFont(f1);
      l3.setBounds(50,75,200,30);
      f.add(l3);

      l5= new JLabel("Successfully Done!");
      l5.setForeground(Color.decode("#8F7F68"));
      l5.setFont(f2);
      l5.setBounds(53,95,200,30);
      f.add(l5);



      l2= new JLabel(balance);
      l2.setForeground(Color.decode("#8F7F68"));
      l2.setFont(f3);
      l2.setBounds(170,140,50,20);
      f.add(l2);

      f.add(l4);
      f.setSize(300,300);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
	}
  public static void main(String[]args)
  {
    //new Sendmoneyalrt(500);
  }

}