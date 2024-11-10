package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JCheckBox available;
    Choice choicecar;
    public Pickup()
    {
        setTitle("Hotel Management System");
        setBounds(300,200,1000,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Pickup Service");
        heading.setBounds(400,30,200,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel car = new JLabel("Car Type");
        car.setBounds(50,100,100,20);
        add(car);

        choicecar = new Choice();
        choicecar.setBounds(150,100,200,25);
        add(choicecar);

        try
        {
            Connections conn = new Connections();
            String query = "Select * from Driver";
            ResultSet result = conn.statement.executeQuery(query);

            while (result.next())
            {
                choicecar.add(result.getString("Car_Company"));
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        available = new JCheckBox("Only display available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel name = new JLabel("Name");
        name.setBounds(30,160,100,20);
        add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(200,160,100,20);
        add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(330,160,100,20);
        add(gender);


        JLabel carcompany = new JLabel("Car Company");
        carcompany.setBounds(460,160,100,20);
        add(carcompany);

        JLabel carmodel = new JLabel("Car Model");
        carmodel.setBounds(630,160,100,20);
        add(carmodel);

        JLabel avilability = new JLabel("Availability");
        avilability.setBounds(740,160,100,20);
        add(avilability);

        JLabel location = new JLabel("Location");
        location.setBounds(890,160,100,20);
        add(location);

        table =new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try
        {
            Connections conn = new Connections();
            String query = "Select * From Driver";
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

                String query1 = "Select * From driver Where Car_Company = '"+choicecar.getSelectedItem()+"'";
               /* String query2 = " Select * From rooms Where Availablibility = 'Available' AND Bed_type = '"+badtype.getSelectedItem()+"'";*/

                ResultSet result;
                result = conn.statement.executeQuery(query1);
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
        new Pickup();
    }


}
