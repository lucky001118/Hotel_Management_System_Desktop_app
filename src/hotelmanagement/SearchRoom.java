package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox badtype;
    JCheckBox available;
    public SearchRoom()
    {
        setTitle("Hotel Management System");
        setBounds(300,200,1000,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Search for Room");
        heading.setBounds(400,30,200,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);

        JLabel bedlbl = new JLabel("Bed Type");
        bedlbl.setBounds(50,100,100,20);
        add(bedlbl);
        badtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
        badtype.setBounds(150,100,150,25);
        badtype.setBackground(Color.WHITE);
        add(badtype);

        available = new JCheckBox("Only display available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(50,160,100,20);
        add(roomno);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(270,160,100,20);
        add(availability);

        JLabel cleaning = new JLabel("Cleaning");
        cleaning.setBounds(450,160,100,20);
        add(cleaning);


        JLabel price = new JLabel("Price");
        price.setBounds(670,160,100,20);
        add(price);

        JLabel bed = new JLabel("Bed Status");
        bed.setBounds(870,160,100,20);
        add(bed);

        table =new JTable();
        table.setBounds(0,200,1000,300);
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
        back.setBounds(500,520,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);

        submit = new JButton("Submit");
        submit.setBounds(300,520,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);

        setVisible(true);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==submit)
        {
            try
            {
               Connections conn = new Connections();

               String query1 = "Select * From rooms Where Bed_type = '"+badtype.getSelectedItem()+"'";
               String query2 = " Select * From rooms Where Availablibility = 'Available' AND Bed_type = '"+badtype.getSelectedItem()+"'";

                ResultSet result;
               if(available.isSelected())
               {
                    result = conn.statement.executeQuery(query2);
               }else
               {
                    result = conn.statement.executeQuery(query1);
               }
                table.setModel(DbUtils.resultSetToTableModel(result));
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        } else if (e.getSource()==back) {

            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new SearchRoom();
    }


}
