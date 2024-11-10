package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {
    Choice choisecustomer;
    JTextField fildroom,fildname,fildcheckin,fildpaid,fildpending ;
    JButton back,update,check;
    public UpdateCheck()
    {
        setTitle("Hotel Management System");
        setBounds(300,200,980,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());

        JLabel head = new JLabel("Update Status");
        head.setFont(new Font("Tahoma",Font.PLAIN,20));
        head.setBounds(90,20,200,30);
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
        room.setBounds(30,120,100,20);
        add(room);

        fildroom = new JTextField();
        fildroom.setBounds(200,120,150,25);
        add(fildroom);

        JLabel name = new JLabel("Name");
        name.setBounds(30,160,150,20);
        add(name);

        fildname = new JTextField();
        fildname.setBounds(200,160,150,25);
        add(fildname);

        JLabel checkin = new JLabel("Check In");
        checkin.setBounds(30,200,150,20);
        add(checkin);

        fildcheckin = new JTextField();
        fildcheckin.setBounds(200,200,150,25);
        add(fildcheckin);

        JLabel paid = new JLabel("Amount Paid");
        paid.setBounds(30,240,150,20);
        add(paid);

        fildpaid = new JTextField();
        fildpaid.setBounds(200,240,150,25);
        add(fildpaid);

        JLabel pending = new JLabel("Pending Amount");
        pending.setBounds(30,280,150,20);
        add(pending);

        fildpending = new JTextField();
        fildpending.setBounds(200,280,150,25);
        add(fildpending);

        check = new JButton("Check");
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        check.setBounds(30,340,100,30);
        add(check);
        check.addActionListener(this);

        update = new JButton("Update");
        update.setForeground(Color.white);
        update.setBackground(Color.BLACK);
        update.setBounds(150,340,100,30);
        add(update);
        update.addActionListener(this);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(270,340,100,30);
        add(back);
        back.addActionListener(this);

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\nine.jpg");
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);


        setVisible(true);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                    fildname.setText(result.getString("Name"));
                    fildcheckin.setText(result.getString("Check_In_Time"));
                    fildname.setText(result.getString("Name"));
                    fildpaid.setText(String.valueOf(result.getInt("Deposit")));
                }

                ResultSet resuit2 = conn.statement.executeQuery("Select  Price From Rooms Where Room_Number= '"+fildroom.getText()+"'");
                while (resuit2.next())
                {

                    int roomprice = Integer.parseInt(resuit2.getString("Price"));
                    System.out.println(roomprice);
                    int paidamaount = Integer.parseInt(fildpaid.getText());
                    int payableamount = roomprice-paidamaount;
                    System.out.println(payableamount);
                    fildpending.setText(String.valueOf(payableamount));
                }

            }catch (Exception ee)
            {
                ee.printStackTrace();
            }
        } else if (e.getSource()==update) {
            String getdocumentnumber = choisecustomer.getSelectedItem();
            String grtroom = fildroom.getText();
            String getname = fildname.getText();
            String getcheckin = fildcheckin.getText();
            String getdeposit = fildpending.getText();

            try
            {
              Connections conn = new Connections();
              String query ="Update Customer Set Room = '"+grtroom+"', Name = '"+getname+"',Check_In_Time = '"+getcheckin+"',Deposit = '"+getdeposit+"' Where Document_Number = '"+getdocumentnumber+"'";
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
        new UpdateCheck();
    }


}
