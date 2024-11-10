package hotelmanagement;

import javax.swing.*;
import java.awt.*;
//import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
    Choice choisecustomer;
    JLabel dataroomno,datacheckin,datacheckout;
    JButton back,btncheckout,check;
    public CheckOut()
    {
        setTitle("Hotel Management System");
        setBounds(300,200,800,400);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);

        JLabel checkouthead =new JLabel("Check Out");
        checkouthead.setForeground(Color.BLUE);
        checkouthead.setBounds(100,20,100,30);
        checkouthead.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(checkouthead);

        JLabel id =new JLabel("Customer ID");
        id.setBounds(30,80,100,30);
        add(id);

        choisecustomer = new Choice();
        choisecustomer.setBounds(150,80,150,25);
        add(choisecustomer);

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\tick.png");
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);

        JLabel roomno =new JLabel("Room Number");
        roomno.setBounds(30,130,100,30);
        add(roomno);

        dataroomno =new JLabel();
        dataroomno.setBounds(150,130,100,30);
        add(dataroomno);

        JLabel checkin =new JLabel("Check-in Time");
        checkin.setBounds(30,180,100,30);
        add(checkin);

        datacheckin =new JLabel();
        datacheckin.setBounds(150,180,150,30);
        add(datacheckin);

        JLabel checkout =new JLabel("Check-out Time");
        checkout.setBounds(30,230,100,30);
        add(checkout);

        Date date = new Date();

        datacheckout =new JLabel(""+ date);
        datacheckout.setBounds(150,230,150,30);
        add(datacheckout);

        try
        {
            Connections conn =new Connections();
            String query = "Select * from Customer";
            ResultSet result = conn.statement.executeQuery(query);
            while (result.next())
            {
                choisecustomer.add(result.getString("Document_Number"));   //here i'm setting in choise option customer document id number to fatch that customer details

                /*dataroomno.setText(result.getString("Room"));
                datacheckin.setText(result.getString("Check_In_Time"));*/
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }


        back = new JButton("Back");
        back.setBounds(230,280,80,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);

        btncheckout = new JButton("Check-out");
        btncheckout.setBounds(130,280,80,30);
        btncheckout.setBackground(Color.BLACK);
        btncheckout.setForeground(Color.WHITE);
        add(btncheckout);
        btncheckout.addActionListener(this);

        check = new JButton("Check");
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        check.setBounds(30,280,80,30);
        add(check);
        check.addActionListener(this);

        ImageIcon i11 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\sixth.jpg");
        Image i22 = i11.getImage().getScaledInstance(400,200,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(350,50,400,250);
        add(image);

        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btncheckout)
        {

            String query1 ="Delete From Customer Where  Document_Number = '"+choisecustomer.getSelectedItem()+"'"; //for delete current customer
            String query2 ="Update Rooms Set Availablibility = 'Available' Where Room_Number = '"+dataroomno.getText()+"'";  //for changing room status
            String query3 ="Update customer_record Set Check_Out_Time = '"+datacheckout.getText()+"' Where Document_Numbe = '"+choisecustomer.getSelectedItem()+"'";  //for add check out time of customer

            try
            {
                Connections conn = new Connections();
                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);
                conn.statement.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Checkout Done");
                setVisible(false);
                new Reception();

            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

        } else if (e.getSource()==back) {
            setVisible(false);
            new Reception();

        } else if (e.getSource()==check) {

            String getid = choisecustomer.getSelectedItem();   //fathching customers document-id

            try
            {
                Connections conn = new Connections();
                String query = "Select * from Customer Where Document_Number = '"+getid+"'";

                ResultSet result = conn.statement.executeQuery(query);
                while (result.next())
                {
                dataroomno.setText(result.getString("Room"));
                datacheckin.setText(result.getString("Check_In_Time"));
                }

            }catch (Exception ee)
            {
                ee.printStackTrace();
            }

        }

    }
    public static void main(String[] args) {
        new CheckOut();
    }


}
