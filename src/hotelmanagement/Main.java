package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hotelmanagement.Login;
import hotelmanagement.*;
public class Main extends JFrame {
    public Main()
    {
       setTitle("Hotel Management System");
        setBounds(100,100,1366,565);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon ii = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\first.jpg");
        JLabel image = new JLabel(ii);
        image.setBounds(0,0,1366,565);
        add(image);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());

        JLabel text = new JLabel("Hotel Management System Application");
        text.setBounds(20,430,1000,90);
        text.setFont(new Font("arial",Font.ITALIC,30));
        text.setForeground(Color.white);
        image.add(text);

        JButton button = new JButton("next");
        button.setBounds(1150,450,150,50);
        button.setBackground(new Color(108, 241, 178, 14));
        button.setForeground(Color.MAGENTA);
        button.setFont(new Font("arial",Font.BOLD,24));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        image.add(button);
        //button.setVisible(false);

        //Adding the Action listner
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new Login();
            }
        });

        /*//-------------***  Progress-Bar  ***------------------------
        JProgressBar progressBar = new JProgressBar(0,100);
        progressBar.setBounds(0,490,1366,40);
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
                button.setVisible(true);

            }
            i= i+2;

        }*/



        setVisible(true);

    }

    public static void main(String[] args) {
        new Main();
    }
}