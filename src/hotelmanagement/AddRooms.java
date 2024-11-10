package hotelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener
{
    JButton addrooms,cancel;
    JTextField fieldroom,fieldprice;
    JComboBox availablecombo,cliningcombo,bedstatuscombo;

    public AddRooms()
    {
        setTitle("Hotel Management System");
        setBounds(350,200,940,470);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel roomno = new JLabel("Room Number");
        roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        roomno.setBounds(60,80,120,20);
        add(roomno);

        fieldroom = new JTextField();
        fieldroom.setBounds(200,80,150,30);
        fieldroom.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(fieldroom);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        available.setBounds(60,130,120,30);
        add(available);

        String availableOptions[] = {"Available","Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);

        JLabel cliningStatus = new JLabel("Cleaning Status");
        cliningStatus.setFont(new Font("Tahoma",Font.PLAIN,16));
        cliningStatus.setBounds(60,180,120,30);
        add(cliningStatus);

        String cliningOptions[] = {"Cleaned","Dirty"};
        cliningcombo = new JComboBox(cliningOptions);
        cliningcombo.setBounds(200,180,150,30);
        cliningcombo.setBackground(Color.white);
        add(cliningcombo);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        price.setBounds(60,230,120,20);
        add(price);

        fieldprice = new JTextField();
        fieldprice.setBounds(200,230,150,30);
        fieldprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(fieldprice);

        JLabel bedtype = new JLabel("Bed Type");
        bedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        bedtype.setBounds(60,280,120,30);
        add(bedtype);

        String bedstatusOptions[] = {"Single Bed","Double Bed"};
        bedstatuscombo = new JComboBox(bedstatusOptions);
        bedstatuscombo.setBounds(200,280,150,30);
        bedstatuscombo.setBackground(Color.white);
        add(bedstatuscombo);

        addrooms = new JButton("Add Rooms");
        addrooms.setForeground(Color.white);
        addrooms.setBackground(Color.BLACK);
        addrooms.setBounds(60,350,130,30);
        add(addrooms);
        addrooms.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\twelve.jpg");
       // Image i2 = i1.getImage().getScaledInstance();

        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addrooms)
        {

            String getroomnumber = fieldroom.getText();
            String getavailabl = (String)availablecombo.getSelectedItem();
            String getCleaning = (String)cliningcombo.getSelectedItem();
            String getprice = fieldprice.getText();
            String getbedstatus = (String)bedstatuscombo.getSelectedItem();

            try
            {
                Connections conn = new Connections();
                String query = "Insert into rooms Values ('"+getroomnumber+"','"+getavailabl+"','"+getCleaning+"','"+getprice+"','"+getbedstatus+"') ";
                int ext = conn.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"New-Room added success-fully");

            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
new AddRooms();
    }



}
