package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class Rooms extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    public Rooms()
    {
        setTitle("Hotel Management System");
        setBounds(300,200,1050,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\eight.jpg");
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(10,10,100,20);
        add(roomno);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(120,10,100,20);
        add(availability);

        JLabel cleaning = new JLabel("Cleaning");
        cleaning.setBounds(230,10,100,20);
        add(cleaning);

        JLabel price = new JLabel("Price");
        price.setBounds(330,10,100,20);
        add(price);

        JLabel bed = new JLabel("Bed Status");
        bed.setBounds(410,10,100,20);
        add(bed);

        table =new JTable();
        table.setBounds(0,40,500,400);
        add(table);

        try
        {
            Connections conn = new Connections();
            String query = "Select * From Rooms";
            ResultSet result = conn.statement.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(result));   //this line autometically sets value in tables using the DbUtils class which is in the rs2xml.jar file
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);

        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new Rooms();
    }


}
