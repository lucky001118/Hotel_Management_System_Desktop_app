package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import hotelmanagement.*;

public class BackgroundFrame extends JFrame {
    public BackgroundFrame()
    {
        setTitle("Hotel Management System");
        setSize(1550,8000);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        add(panel1,BorderLayout.WEST);
        panel1.setBounds(0,0,450,8000);
        panel1.setBackground(new Color(71, 116, 83));
        //panel1.setBackground(Color.WHITE);

        /*ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\home.png");
        Image i2 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel menulabel = new JLabel(i3);
        menulabel.setBounds(20,20,50,50);
        panel1.add(menulabel);

        JButton home = new JButton("Menu ");
        home.setBounds(80,20,50,50);
        //home.setFont(new Font("Tahoma",Font.BOLD,20));
        home.setBackground(new Color(250,252,252,0));
        home.setForeground(Color.WHITE);
        home.setBorder(null);
        panel1.add(home);


        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                ImageIcon i4 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\reception.png");
                Image i5 = i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);

                JLabel l2 = new JLabel(i6);
                l2.setBounds(20,100,50,50);
                panel1.add(l2);

                JButton menuitem1 = new JButton("Reception");
                menuitem1.setBounds(80,100,100,50);
                //home.setFont(new Font("Tahoma",Font.BOLD,20));
                menuitem1.setBackground(new Color(250,252,252,0));
                menuitem1.setForeground(Color.WHITE);
                menuitem1.setBorder(null);
                panel1.add(menuitem1);
            }
        });*/

        JPanel panel2 = new JPanel();
        add(panel2,BorderLayout.CENTER);
        panel2.setLayout(null);
        panel2.setBounds(450,0,1100,8000);
        panel2.setBackground(new Color(104, 162, 125));

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\photo.jpg");
        Image i2 = i1.getImage().getScaledInstance(1000,850,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel backimage = new JLabel(i3);
        backimage.setBounds(50,50,1000,700);
        panel2.add(backimage);


        /*JButton button = new JButton("Click-me ...");
        button.setFont( new Font("arial",Font.BOLD,27));
        button.setBounds(100,100,150,40);
        panel2.add(button,BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JWindow window = new JWindow();
                window.setBounds(10,50,400,300);
                window.setLocationRelativeTo(null);
                window.setVisible(true);

                JEditorPane editorPane = new JEditorPane();
                editorPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                editorPane.setSize(350,280);
                editorPane.setContentType("text/plain");
                editorPane.setText("An aircraft in straight-and-level unaccelerated flight has four forces acting on it. (In turning, diving, or climbing flight, additional forces come into play.) These forces are lift, an upward-acting force; drag, a retarding force of the resistance to lift and to the friction of the aircraft moving through the air; weight, the downward effect that gravity has on the aircraft; and thrust, the forward-acting force provided by the propulsion system (or, in the case of unpowered aircraft, by using gravity to translate altitude into speed). Drag and weight are elements inherent in any object, including an aircraft. Lift and thrust are artificially created elements devised to enable an aircraft to fly.");
                //editorPane.setText("Thanks");
                editorPane.setFont( new Font("New Times Roman",Font.ITALIC,17));

                Color color = new Color(245, 215, 115,0);
                window.setBackground(color);
                editorPane.setBackground(color);
                window.add(editorPane);

            }
        });*/

        setVisible(true);

        try
        {
            Thread.sleep(2000);
            WelcomePage wp = new WelcomePage();

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }


    }
    public static void main(String[] args) {

        BackgroundFrame bf = new BackgroundFrame();
    }
}
