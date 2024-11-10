package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import hotelmanagement.*;
public class WelcomePage extends JFrame
{
    public WelcomePage()
    {
        setTitle("Hotel Management System");
        setBounds(200,100,1200,700);
        setLayout(null);
        getContentPane().setBackground(Color.BLUE);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());


        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel backimage = new JLabel(i3);
        backimage.setBounds(550,200,100,100);
        add(backimage);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(300,350,600,40);
        text.setFont(new Font("Tahoma",Font.BOLD,34));
        text.setForeground(Color.WHITE);
        add(text);

        JLabel text2 = new JLabel("India's best and classic hotel ever");
        text2.setBounds(500,395,300,30);
        text2.setFont(new Font("Tahoma",Font.PLAIN,14));
        text2.setForeground(Color.WHITE);
        add(text2);

        //-------------***  Progress-Bar  ***------------------------
        JProgressBar progressBar = new JProgressBar(0,100);
        progressBar.setBounds(0,635,1200,30);
        progressBar.setFont( new Font("arial",Font.CENTER_BASELINE,30));
        progressBar.setOrientation(SwingConstants.HORIZONTAL);   //for this bar will showing us horizontally
        progressBar.setStringPainted(true);         //this will showing the progress percentaage
        progressBar.setBackground(Color.GREEN);
        add(progressBar);
        // progressBar.setValue(70);

        setVisible(true);

        int i=0;
        while (i<=100) {
            progressBar.setValue(i);
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("The value of i is: " + i);
            if(i==100)
            {
                progressBar.setVisible(false);

                new Menu();

            }
            i= i+2;

        }
        setVisible(false);
        new Main();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new WelcomePage();
    }
}
