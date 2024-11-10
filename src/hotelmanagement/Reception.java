package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton newcustomer,rooms,department,allemployee,managerinfo,customers,searchroom,updatests,roomstatus,pickup,checkout,logout;
    public Reception()
    {
        setTitle("Hotel Management System");
        setBounds(350,200,800,570);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);

        newcustomer = new JButton("Add Customer Forms");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        add(newcustomer);
        newcustomer.addActionListener(this);

        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        add(rooms);
        rooms.addActionListener(this);

        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        add(department);
        department.addActionListener(this);

        allemployee = new JButton("All Employee");
        allemployee.setBounds(10,150,200,30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        add(allemployee);
        allemployee.addActionListener(this);
        customers = new JButton("Customer Information");
        customers.setBounds(10,190,200,30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        add(customers);
        customers.addActionListener(this);

        managerinfo = new JButton("Manager Information");
        managerinfo.setBounds(10,230,200,30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        add(managerinfo);
        managerinfo.addActionListener(this);

        checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);
        checkout.addActionListener(this);

        updatests = new JButton("Update Status");
        updatests.setBounds(10,310,200,30);
        updatests.setBackground(Color.BLACK);
        updatests.setForeground(Color.WHITE);
        add(updatests);
        updatests.addActionListener(this);

        roomstatus = new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        add(roomstatus);
        roomstatus.addActionListener(this);

        pickup = new JButton("Pick-Up Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        add(pickup);
        pickup.addActionListener(this);

        searchroom = new JButton("Search Rooms");
        searchroom.setBounds(10,430,200,30);
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        add(searchroom);
        searchroom.addActionListener(this);

        logout = new JButton("Log Out");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);
        logout.addActionListener(this);

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\fourth.jpg");
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);

        setVisible(true);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==newcustomer)
        {
            setVisible(false);
            new AddCustomer();
        } else if (e.getSource()==rooms) {

            setVisible(false);
            new Rooms();
        } else if (e.getSource()==department) {

            setVisible(false);
            new Department();
        }else if (e.getSource()==allemployee) {

            setVisible(false);
            new EmployeeInformation();
        }else if (e.getSource()==managerinfo) {

            setVisible(false);
            new ManagerInformation();
        }else if (e.getSource()==customers) {

            setVisible(false);
            new CustomerInformation();
        }else if (e.getSource()==searchroom) {

            setVisible(false);
            new SearchRoom();
        }else if (e.getSource()==updatests) {

            setVisible(false);
            new UpdateCheck();
        }else if (e.getSource()==roomstatus) {

            setVisible(false);
            new UpdateRoom();
        }else if (e.getSource()==pickup) {

            setVisible(false);
            new Pickup();
        }else if (e.getSource()==checkout) {

            setVisible(false);
            new CheckOut();
        }else if (e.getSource()==logout) {

            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Reception();
    }


}
