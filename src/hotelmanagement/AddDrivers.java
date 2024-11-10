package hotelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener
{
    JButton adddriver,cancel;
    JTextField fielddirname,fielddirage,fieidcarcompany,fieldcarmodel,dirlocation;
    JComboBox dirgendercombo,diravailablecombo;

    public AddDrivers()
    {
        setTitle("Hotel Management System");
        setBounds(350,200,980,470);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);

        JLabel dirname = new JLabel("Name");
        dirname.setFont(new Font("Tahoma",Font.PLAIN,16));
        dirname.setBounds(60,70,120,20);
        add(dirname);

        fielddirname = new JTextField();
        fielddirname.setBounds(200,70,150,30);
        fielddirname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(fielddirname);

        JLabel dirage = new JLabel("Age");
        dirage.setFont(new Font("Tahoma",Font.PLAIN,16));
        dirage.setBounds(60,110,120,30);
        add(dirage);

        fielddirage = new JTextField();
        fielddirage.setBounds(200,110,150,30);
        fielddirage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(fielddirage);

        JLabel dirgender = new JLabel("Gender");
        dirgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        dirgender.setBounds(60,150,120,30);
        add(dirgender);

        String genderOptions[] = {"Male","Female"};
        dirgendercombo = new JComboBox(genderOptions);
        dirgendercombo.setBounds(200,150,150,30);
        dirgendercombo.setBackground(Color.white);
        add(dirgendercombo);

        JLabel carcom = new JLabel("Car-Company");
        carcom.setFont(new Font("Tahoma",Font.PLAIN,16));
        carcom.setBounds(60,190,120,20);
        add(carcom);

        fieidcarcompany = new JTextField();
        fieidcarcompany.setBounds(200,190,150,30);
        fieidcarcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(fieidcarcompany);

        JLabel carmodel = new JLabel("Car-Model");
        carmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
        carmodel.setBounds(60,230,120,30);
        add(carmodel);

        fieldcarmodel = new JTextField();
        fieldcarmodel.setBounds(200,230,150,30);
        fieldcarmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(fieldcarmodel);

        JLabel diravaiebel = new JLabel("Availability");
        diravaiebel.setFont(new Font("Tahoma",Font.PLAIN,16));
        diravaiebel.setBounds(60,270,120,30);
        add(diravaiebel);

        String availableOptions[] = {"Available","Busy"};
        diravailablecombo = new JComboBox(availableOptions);
        diravailablecombo.setBounds(200,270,150,30);
        diravailablecombo.setBackground(Color.white);
        add(diravailablecombo);

        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.PLAIN,16));
        location.setBounds(60,310,120,30);
        add(location);

        dirlocation = new JTextField();
        dirlocation.setBounds(200,310,150,30);
        dirlocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(dirlocation);

        adddriver = new JButton("Add Driver");
        adddriver.setForeground(Color.white);
        adddriver.setBackground(Color.BLACK);
        adddriver.setBounds(60,370,130,30);
        add(adddriver);
        adddriver.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,370,130,30);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\eleven.jpg");
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==adddriver)
        {

            String getdirname = fielddirname.getText();
            int getdirage = Integer.parseInt(fielddirage.getText());
            String getdirgender = (String)dirgendercombo.getSelectedItem();
            String getcarcompany = fieidcarcompany.getText();
            String getcarmodel = fieldcarmodel.getText();
            String getdiravailable = (String)diravailablecombo.getSelectedItem();
            String getdirlocation = dirlocation.getText();

            try
            {
                Connections conn = new Connections();
                String query = "Insert into Driver Values ('"+getdirname+"','"+getdirage+"','"+getdirgender+"','"+getcarcompany+"','"+getcarmodel+"','"+getdiravailable+"','"+getLocale()+"') ";
                int ext = conn.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"New Driver added success-fully");

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
        new AddDrivers();
    }



}
