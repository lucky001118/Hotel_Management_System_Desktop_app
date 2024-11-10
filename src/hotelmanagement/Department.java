package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    public Department()
    {
        setTitle("Hotel Management System");
        setBounds(400,200,700,480);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);

        JLabel department = new JLabel("Department");
        department.setBounds(180,10,100,20);
        add(department);

        JLabel budget = new JLabel("Budget");
        budget.setBounds(450,10,100,20);
        add(budget);

        table =new JTable();
        table.setBounds(0,50,700,350);
        add(table);

        try
        {
            Connections conn = new Connections();
            String query = "Select * From Department";
            ResultSet result = conn.statement.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(result));   //this line autometically sets value in tables using the DbUtils class which is in the rs2xml.jar file
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(280,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);

        setVisible(true);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new Department();
    }


}
