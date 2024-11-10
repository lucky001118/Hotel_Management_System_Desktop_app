package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class EmployeeInformation extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    public EmployeeInformation()
    {
        setTitle("Hotel Management System");
        setBounds(300,200,1000,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);

        JLabel name = new JLabel("Name");
        name.setBounds(40,10,100,20);
        add(name);

        JLabel availability = new JLabel("Age");
        availability.setBounds(170,10,100,20);
        add(availability);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(290,10,100,20);
        add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(400,10,100,20);
        add(job);

        JLabel salery = new JLabel("Salary");
        salery.setBounds(530,10,100,20);
        add(salery);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(670,10,100,20);
        add(phone);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(790,10,100,20);
        add(aadhar);

        JLabel email = new JLabel("Email ID");
        email.setBounds(910,10,100,20);
        add(email);


        table =new JTable();
        table.setBounds(0,40,1000,400);
        add(table);

        try
        {
            Connections conn = new Connections();
            String query = "Select * From Employee";
            ResultSet result = conn.statement.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(result));   //this line autometically sets value in tables using the DbUtils class which is in the rs2xml.jar file
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(420,500,120,30);
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
        new EmployeeInformation();
    }


}
