package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice choisecustomer;
    JTextField fildroom,fildpaid,fildpending ;
    JButton back,update,check;
    JComboBox cliningcombo,availablecombo;
    public UpdateRoom()
    {
        setTitle("Hotel Management System");
        setBounds(300,200,980,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());

        JLabel head = new JLabel("Update Rooms Status");
        head.setFont(new Font("Tahoma",Font.PLAIN,20));
        head.setBounds(30,20,250,30);
        head.setForeground(Color.BLUE);
        add(head);

        JLabel id = new JLabel("Customer ID");
        id.setBounds(30,80,100,20);
        add(id);

        choisecustomer = new Choice();
        choisecustomer.setBounds(200,80,100,20);
        add(choisecustomer);

        try
        {
            Connections conn =new Connections();
            String query = "Select * from Customer";
            ResultSet result = conn.statement.executeQuery(query);
            while (result.next())
            {
                choisecustomer.add(result.getString("Document_Number"));   //here i'm setting in choise option customer document id number to fatch that customer details

            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        JLabel room = new JLabel("Room Number");
        room.setBounds(30,130,100,20);
        add(room);

        fildroom = new JTextField();
        fildroom.setBounds(200,130,150,25);
        add(fildroom);

        JLabel avaibility = new JLabel("Availability");
        avaibility.setBounds(30,180,150,20);
        add(avaibility);

       /* fildavailability = new JTextField();
        fildavailability.setBounds(200,180,150,25);
        add(fildavailability);*/

        String availableOptions[] = {"Available","Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,180,150,25);
        availablecombo.setBackground(Color.white);
        add(availablecombo);

        JLabel cleaning = new JLabel("Cleaning Status");
        cleaning.setBounds(30,230,150,20);
        add(cleaning);

       /* fildcleaning = new JTextField();
        fildcleaning.setBounds(200,230,150,25);
        add(fildcleaning);*/

        String cliningOptions[] = {"Cleaned","Dirty"};
        cliningcombo = new JComboBox(cliningOptions);
        cliningcombo.setBounds(200,230,150,25);
        cliningcombo.setBackground(Color.white);
        add(cliningcombo);

        check = new JButton("Check");
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        check.setBounds(30,300,100,30);
        add(check);
        check.addActionListener(this);

        update = new JButton("Update");
        update.setForeground(Color.white);
        update.setBackground(Color.BLACK);
        update.setBounds(150,300,100,30);
        add(update);
        update.addActionListener(this);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(270,300,100,30);
        add(back);
        back.addActionListener(this);

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\seventh.jpg");
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);


        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==check)
        {
            String getid = choisecustomer.getSelectedItem();   //fathching customers document-id

            Connections conn = new Connections();
            String query = "Select * from Customer Where Document_Number = '"+getid+"'";
            try
            {
                ResultSet result = conn.statement.executeQuery(query);
                while (result.next())
                {
                    fildroom.setText(result.getString("Room"));

                  /*  fildcleaning.setText(result.getString("Check_In_Time"));
                    fildavailability.setText(result.getString("Name"));
                    fildpaid.setText(String.valueOf(result.getInt("Deposit")));*/
                }

                ResultSet resuit2 = conn.statement.executeQuery("Select * From Rooms Where Room_Number= '"+fildroom.getText()+"'");
                while (resuit2.next())
                {
                    availablecombo.setSelectedItem(resuit2.getString("Availablibility"));
                    cliningcombo.setSelectedItem(resuit2.getString("Cleaning_Status"));

                }

            }catch (Exception ee)
            {
                ee.printStackTrace();
            }
        } else if (e.getSource()==update) {
            String getdocumentnumber = choisecustomer.getSelectedItem();
            String grtroom = fildroom.getText();
            String getcleaning = (String) cliningcombo.getSelectedItem();
            String getavilability = (String) availablecombo.getSelectedItem();

            try
            {
                Connections conn = new Connections();
                String query ="Update Rooms Set Cleaning_Status = '"+getcleaning+"',Availablibility = '"+getavilability+"' Where Room_Number = '"+grtroom+"'";
                int update = conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Data Updated successfully!");

                setVisible(false);
                new Reception();
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

        } else if (e.getSource()==back) {

            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new UpdateRoom();
    }


}
