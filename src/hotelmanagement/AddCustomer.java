package hotelmanagement;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
    JComboBox idcombo;
    JTextField fildidnumber,fildname,fildcountry,filddeposit;
    JRadioButton male,female;
    Choice roomchois;
    JLabel checkintimedata;
    JButton addcustomer,back;
    public AddCustomer()
    {
        setTitle("Hotel Management System");
        setBounds(350,200,800,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("New Customer Form");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        add(text);

        JLabel id = new JLabel("ID");
        id.setBounds(35,80,100,18);
        id.setFont(new Font("Raleway",Font.PLAIN,15));
        add(id);

        String idoptions[]={"Aadhar Card","Passport","Driving Licence","Voter-id Curd","Rashan Curd"};
        idcombo = new JComboBox(idoptions);
        idcombo.setBounds(200,80,150,25);
        idcombo.setBackground(Color.WHITE);
        add(idcombo);

        JLabel idnumber = new JLabel("ID Number");
        idnumber.setBounds(35,120,100,15);
        idnumber.setFont(new Font("Raleway",Font.PLAIN,15));
        add(idnumber);

        fildidnumber = new JTextField();
        fildidnumber.setBounds(200,120,150,25);
        add(fildidnumber);

        JLabel name = new JLabel("Name");
        name.setBounds(35,160,100,20);
        name.setFont(new Font("Raleway",Font.PLAIN,15));
        add(name);

        fildname = new JTextField();
        fildname.setBounds(200,160,150,25);
        add(fildname);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(35,200,100,20);
        gender.setFont(new Font("Raleway",Font.PLAIN,15));
        add(gender);

        male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(200,200,60,25);
        add(male);

        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(270,200,100,25);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel country = new JLabel("Country");
        country.setBounds(35,240,100,20);
        country.setFont(new Font("Raleway",Font.PLAIN,15));
        add(country);

        fildcountry = new JTextField();
        fildcountry.setBounds(200,240,150,25);
        add(fildcountry);

        JLabel allocatedroom = new JLabel("Allocated Rooms");
        allocatedroom.setBounds(35,280,150,20);
        allocatedroom.setFont(new Font("Raleway",Font.PLAIN,15));
        add(allocatedroom);

        roomchois = new Choice();
        try {
            Connections conn = new Connections();
            String query ="Select * From rooms Where Availablibility = 'Available'";
            ResultSet result = conn.statement.executeQuery(query);
            while (result.next()==true)
            {
                roomchois.add(result.getString("Room_Number"));
            }

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        roomchois.setBounds(200,280,150,20);
        add(roomchois);

        JLabel checkintime = new JLabel("Check-in Time");
        checkintime.setBounds(35,320,150,20);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkintime);

        Date date = new Date();

        checkintimedata = new JLabel(""+date);
        checkintimedata.setBounds(200,320,150,20);
        checkintimedata.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkintimedata);

        JLabel deposit = new JLabel("Deposit Money");
        deposit.setBounds(35,360,150,20);
        deposit.setFont(new Font("Raleway",Font.PLAIN,15));
        add(deposit);

        filddeposit = new JTextField();
        filddeposit.setBounds(200,360,150,30);
        add(filddeposit);

        addcustomer = new JButton("Add");
        addcustomer.setBounds(50,410,120,30);
        addcustomer.setBackground(Color.BLACK);
        addcustomer.setForeground(Color.WHITE);
        add(addcustomer);
        addcustomer.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(200,410,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\fifth.png");
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==addcustomer)
        {
            String getid = (String)idcombo.getSelectedItem();
            String getidnumber = fildidnumber.getText();
            String getname = fildname.getText();
            String getgender = null;

                if(male.isSelected())
                {
                    getgender = "Male";
                }else
                {
                    getgender = "Female";
                }

                String getcountry = fildcountry.getText();
                String getrooms = roomchois.getSelectedItem();
                String getcheckintime =  checkintimedata.getText();
                int getdeposit = Integer.parseInt(filddeposit.getText());

                try {

                    Connections conn =new Connections();
                    String query = "Insert Into Customer Values('"+getid+"','"+getidnumber+"','"+getname+"','"+getgender+"','"+getcountry+"','"+getrooms+"','"+getcheckintime+"','"+getdeposit+"')";
                    String query2 = "Update Rooms Set Availablibility = 'Occupied' Where Room_Number = '"+getrooms+"'";  //for updating avalability in rooms table
                    String query3 = "Insert Into customer_record Values('"+getid+"','"+getidnumber+"','"+getname+"','"+getgender+"','"+getcountry+"','"+getrooms+"','"+getcheckintime+"','Staying')";
                    int result = conn.statement.executeUpdate(query);
                    int result2 = conn.statement.executeUpdate(query2);
                    conn.statement.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null,"New Customer Added Success-fully!");

                    setVisible(false);
                    new Reception();

                }catch(Exception ex){
                    ex.printStackTrace();
                }

        } else if (e.getSource()==back) {

            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new AddCustomer();
    }



}
