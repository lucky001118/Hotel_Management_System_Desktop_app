package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hotelmanagement.AddEmployee;
import  hotelmanagement.AddRooms;
import hotelmanagement.AddDrivers;
import hotelmanagement.Reception;
import hotelmanagement.*;

public class Dashboard extends JFrame implements ActionListener
{
    public Dashboard()
    {
        setTitle("Hotel Management System");
        setBounds(0,0,1550,1000);
        setTitle("Hotel Management System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\third.jpg");
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.ITALIC,46));
        image.add(text);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0,0,1550,30);
        menuBar.setBackground( new Color(240, 187, 72,130));
        image.add(menuBar);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        menuBar.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        hotel.add(reception);
        reception.addActionListener(this);

        JMenu admin = new JMenu("ADMIN");
        menuBar.add(admin);

        JMenuItem addemp = new JMenuItem("Add Employees");
        admin.add(addemp);
        addemp.addActionListener(this);

        JMenuItem addroom = new JMenuItem("Add Rooms");
        admin.add(addroom);
        addroom.addActionListener(this);

        JMenuItem adddr = new JMenuItem("Add Drivers");
        admin.add(adddr);
        adddr.addActionListener(this);

        JMenuItem cusrecord = new JMenuItem("All Customer Records");
        admin.add(cusrecord);
        cusrecord.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Add Employees"))
        {
            new AddEmployee();
        } else if (e.getActionCommand().equals("Add Rooms")) {

            new AddRooms();
        } else if (e.getActionCommand().equals("Add Drivers")) {

            new AddDrivers();
        } else if (e.getActionCommand().equals("RECEPTION")) {
            new Reception();

        }else if (e.getActionCommand().equals("All Customer Records")) {
            new AllCustomerRecords();
        }

    }
    public static void main(String[] args)
    {
       Dashboard db = new Dashboard();
    }


}
