package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField namefild, agefild,phonefild,saleryfild,emailfild,aadharfild;
    JRadioButton male,female;
    JComboBox comboBox;
    JButton submit;
    public AddEmployee()
    {
        setBounds(350,200,850,540);
        setTitle("Hotel Management System");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());


        JLabel name = new JLabel("Name");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);

        namefild = new JTextField();
        namefild.setBounds(200,30,150,30);
        add(namefild);

        JLabel age = new JLabel("Age");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);

        agefild = new JTextField();
        agefild.setBounds(200,80,150,30);
        add(agefild);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(200,130,70,30);
        add(male);
        male.setFont(new Font("Tahoma",Font.PLAIN,14));
        male.setBackground(Color.white);

        female = new JRadioButton("Female");
        female.setBounds(280,130,70,30);
        add(female);
        female.setFont(new Font("Tahoma",Font.PLAIN,14));
        female.setBackground(Color.white);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel job = new JLabel("Post");
        job.setBounds(60,180,120,30);
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(job);

        String jbostr [] = {"Front Desk Clerk","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
        comboBox = new JComboBox(jbostr);
        comboBox.setBounds(200,180,150,30);
        comboBox.setBackground(Color.white);
        add(comboBox);

        JLabel salery = new JLabel("Salary");
        salery.setBounds(60,230,120,30);
        salery.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(salery);

        saleryfild = new JTextField();
        saleryfild.setBounds(200,230,150,30);
        add(saleryfild);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(60,280,120,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(phone);

        phonefild = new JTextField();
        phonefild.setBounds(200,280,150,30);
        add(phonefild);

        JLabel email = new JLabel("Email");
        email.setBounds(60,330,120,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(email);

        emailfild = new JTextField();
        emailfild.setBounds(200,330,150,30);
        add(emailfild);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(60,380,120,30);
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(aadhar);

        aadharfild = new JTextField();
        aadharfild.setBounds(200,380,150,30);
        add(aadharfild);

        submit = new JButton("Submit");
        submit.setBounds(200,430,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\tenth.jpg");
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String getname = namefild.getText();
        int getage = Integer.parseInt(agefild.getText());
        int getsalery = Integer.parseInt(saleryfild.getText());
        long getphone = Long.parseLong(phonefild.getText());
        long getaadhar = Long.parseLong(aadharfild.getText());
        String getemail = emailfild.getText();

        String getgender = null;

        System.out.println(getname);
        //validetion
        if(getname.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Name should not empty");
            return;
        }
        if(getemail.equals(""))
        {
            JOptionPane.showMessageDialog(null,"EmailSection should not empty");
            return;
        }

        if(aadharfild.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Aadhar should not empty");
        }
         if (male.isSelected())
         {
             getgender="Male";
         }else if (female.isSelected())
         {
             getgender = "Female";
         }

         String getjob = (String) comboBox.getSelectedItem();

         try
         {
             Class.forName("com.mysql.cj.jdbc.Driver");

             String url = "jdbc:mysql://localhost:3306/hotelmanagementsystem";

             String username = "root";
             String pass = "Lucky@server2002";
             Connection connection = DriverManager.getConnection(url, username, pass);
             String query = "Insert into employee Values(?,?,?,?,?,?,?,?)";
             PreparedStatement statement = connection.prepareStatement(query);
             statement.setString(1,getname);
             statement.setInt(2,getage);
             statement.setString(3,getgender);
             statement.setString(4,getjob);
             statement.setInt(5,getsalery);
             statement.setLong(6,getphone);
             statement.setLong(7,getaadhar);
             statement.setString(8,getemail);
             statement.executeUpdate();

             JOptionPane.showMessageDialog(null,"Employee added successfully!");

             connection.close();
             setVisible(false);

         }catch (Exception ex)
         {
             ex.printStackTrace();
         }
    }
    public static void main(String[] args) {
        new AddEmployee();

    }

}
