package Class;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.table.DefaultTableModel;
class UserInfo
{

	JFrame f= new JFrame();
	JTable table;
	JButton b1,b2,b3;
	JLabel l1;
    JSeparator j1;
	

    Font f1= new Font("Roboto",Font.BOLD,12);
    Font f2= new Font("Couture",Font.BOLD,33);
    Font f3= new Font("Roboto",Font.BOLD,14);

    private String[] column = { "Full Name", "Number", "Email", "Username", "Password" };
    private String[] rows = new String[6];


	UserInfo()
	{
        Image icon = Toolkit.getDefaultToolkit().getImage(".\\image\\logo.png");
        f.setIconImage(icon);
        f.setTitle("CashTrax");

        l1= new JLabel("USER INFORMATIONS");
        l1.setForeground(Color.decode("#F4682D"));
        l1.setBounds(60,3,400,100);
        l1.setFont(f2);
        f.add(l1);


        b1= new JButton("Pervious");
        b1.setFont(f3);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.decode("#F4682D"));
        b1.setBounds(40,410,100,35);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
                new AdminDashboard();
            }
        });
        f.add(b1);

        b2 = new JButton("Exit");
        b2.setFont(f3);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.decode("#F4682D"));
        b2.setBounds(350,410,100,35);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
                System.exit(0);
            }
        });
        f.add(b2);

        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(f1);
        table.setSelectionBackground(Color.decode("#EEA782"));
        table.setBackground(Color.WHITE);
        table.setSelectionBackground(Color.decode("#EEA782"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(20, 97, 450, 250);
        scroll.setBackground(Color.WHITE);
        f.add(scroll);

        String file = ".\\data\\user_info.txt";
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0, 4);
                if (x.equals("User")) {
                   rows[0] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(11);
                   rows[1] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(14);
                   rows[2] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(7);
                   rows[3] = Files.readAllLines(Paths.get(file)).get(i).substring(11);
                   rows[4] = Files.readAllLines(Paths.get(file)).get(i+1).substring(10);
                   model.addRow(rows); 
                    
                }
            }

        } catch (Exception ex) {
            return;
        }

		f.setSize(500,500);
        f.setLocationRelativeTo(null);
		f.setLayout(null);
        f.setResizable(false);
        f.setVisible(true);	
    }
public static void main(String[]args)
	{
		new UserInfo();
	}
}