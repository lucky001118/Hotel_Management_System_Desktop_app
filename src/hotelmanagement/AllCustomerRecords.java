package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class AllCustomerRecords extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    public AllCustomerRecords()
    {
        setTitle("Hotel Management System");
        setBounds(50,40,1400,950);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);

        JLabel documenttype = new JLabel("Document Type");
        documenttype.setBounds(25,10,100,20);
        add(documenttype);

        JLabel documentnumber = new JLabel("ID Number");
        documentnumber.setBounds(200,10,100,20);
        add(documentnumber);

        JLabel name = new JLabel("Name");
        name.setBounds(375,10,100,20);
        add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(550,10,100,20);
        add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(730,10,100,20);
        add(country);

        JLabel noom = new JLabel("Room Number");
        noom.setBounds(910,10,100,20);
        add(noom);

        JLabel cleaningstatus = new JLabel("Check-in Time");
        cleaningstatus.setBounds(1070,10,100,20);
        add(cleaningstatus);

        JLabel deposit = new JLabel("Check-out Time");
        deposit.setBounds(1250,10,100,20);
        add(deposit);


        table =new JTable();
        table.setBounds(0,40,1400,900);
        add(table);

        try
        {
            Connections conn = new Connections();
            String query = "Select * From Customer_record";
            ResultSet result = conn.statement.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(result));   //this line autometically sets value in tables using the DbUtils class which is in the rs2xml.jar file
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(420,950,120,30);
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
        new AllCustomerRecords();
    }


}
