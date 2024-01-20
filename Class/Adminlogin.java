package Class;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Adminlogin
{
	JFrame f= new JFrame();
	JButton b1,b2,b3,b4,b5;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1;
	JPasswordField pass;
	JTable tabel;
	ImageIcon m1;

    Font f1= new Font("Roboto",Font.BOLD,22);
    Font f2= new Font("Roboto",Font.BOLD,17);
    Font f4= new Font("Roboto",Font.BOLD,18);
    Font f3= new Font("Roboto",Font.BOLD,25);
    Font f5= new Font("Roboto",Font.BOLD,14);




	Adminlogin()
	{
     Image icon = Toolkit.getDefaultToolkit().getImage(".\\image\\logo.png");
     f.setIconImage(icon);
     f.setTitle("CashTrax");

	 m1 = new ImageIcon(".\\image\\BG.png");
	 l1= new JLabel(m1);


	 l2= new JLabel("Admin ID : ");
     l2.setForeground(Color.decode("#8F7F68"));
     l2.setFont(f1);
     l2.setBounds(95,140,120,30);
     f.add(l2);

     t1= new JTextField();
     t1.setFont(f4);
     t1.setForeground(Color.decode("#8F7F68"));
     t1.setBorder(BorderFactory.createEmptyBorder());
     JSeparator s1 = new JSeparator();
     s1.setBounds(95,205,190,10);
     s1.setForeground(Color.decode("#8F7F68"));
     s1.setBackground(Color.decode("#8F7F68"));    
     f.add(s1);
     t1.setBounds(95,165,190,40);
     f.add(t1);


     l3= new JLabel("Admin Password :");
     l3.setForeground(Color.decode("#8F7F68"));
     l3.setFont(f1);
     l3.setBounds(95,240,200,20);
     f.add(l3);


     pass= new JPasswordField();
     pass.setFont(f3);
     pass.setEchoChar('*');
     pass.setForeground(Color.decode("#8F7F68"));
     pass.setBorder(BorderFactory.createEmptyBorder());
     //pass.addActionListener(this);

     JSeparator s = new JSeparator();
     s.setForeground(Color.decode("#8F7F68"));
     s.setBackground(Color.decode("#8F7F68")); 
     s.setBounds(95,300,190,10);
     f.add(s);
     pass.setBounds(95,260,190,40);
     f.add(pass);

     b1= new JButton("Login");
     b1.setFont(f2);
     b1.setBorder(BorderFactory.createEmptyBorder());
     b1.setForeground(Color.WHITE);
     b1.setBackground(Color.decode("#F4682D"));
     b1.setBounds(195,320,90,35);
     b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            String username=t1.getText();
            String password= pass.getText();
            if(t1!=null && pass!=null)
            {
                if(username.equals("admin") && password.equals("admin"))
                {
                    f.setVisible(false);
                    new AdminDashboard();
                }
                else 
                {
                JOptionPane.showMessageDialog(null,"Incorrect Username or Password","Invail Info",0);

                }
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"Enter your Username and Password","Warning",2);
            }
        }
     });
     f.add(b1);

     b2= new JButton("Previous");
     b2.setFont(f5);
     b2.setBorder(BorderFactory.createEmptyBorder());
     b2.setForeground(Color.WHITE);
     b2.setBackground(Color.decode("#F4682D"));
     b2.setBounds(30,410,90,30);
     b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            f.setVisible(false);
            new Login();
        }
     });
     f.add(b2);

     b3= new JButton("Exit");
     b3.setFont(f5);
     b3.setBorder(BorderFactory.createEmptyBorder());
     b3.setForeground(Color.WHITE);
     b3.setBackground(Color.decode("#F4682D"));
     b3.setBounds(265,410,90,30);
     b3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            f.setVisible(false);
            System.exit(0);
        }
     });
     f.add(b3);

     f.add(l1);
	 f.setSize(400,500);
     f.setLocationRelativeTo(null);
     f.setVisible(true);
	}
	public static void main(String []atgs)
	{
		new Adminlogin();
	}
}