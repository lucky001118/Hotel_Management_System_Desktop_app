package hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField username,password;
    JPasswordField pass2;
    JButton login,cancel;
    public Login()
    {
        setBounds(500,200,600,300);
        setTitle("Hotel Management System");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon logo = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\Shop-256.png");
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.WHITE);


        JLabel user = new JLabel("Username : ");
        user.setBounds(40,20,100,30);
        add(user);

        username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass = new JLabel("Password : ");
        pass.setBounds(40,70,100,30);
        add(pass);

        pass2 = new JPasswordField();
        pass2.setBounds(150,70,150,30);
        pass2.setEchoChar('*');  //This line of code change password normal partton to the *
        pass2.setFont( new Font("Arial",Font.BOLD,14));
        add(pass2);

        ImageIcon eye = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\eye.png");
        Image eye1 = eye.getImage().getScaledInstance(40,30,Image.SCALE_DEFAULT);
        ImageIcon eye2= new ImageIcon(eye1);
        JButton showpass = new JButton();
        showpass.setBounds(310,70,40,30);
        showpass.setIcon(eye2);
        showpass.setBackground(Color.white);
        showpass.setBorder(null);
        add(showpass);
        showpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pass2.getEchoChar()=='*'){
                    pass2.setEchoChar((char)0);
                }
                else
                {
                    pass2.setEchoChar('*');
                }
            }
        });

        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon("C:\\Users\\manik\\IdeaProjects\\Hotel Management System\\src\\icons\\second.jpg");
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);   //scalling the image
        ImageIcon i3 = new ImageIcon(i2);  //converting the Image class object into the ImageIcon class object becouse Image class object inJLable gives an error.
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==login)
        {
            String getuser = username.getText();
            String getpass =pass2.getText();
            //password.setEchoChar((char)0);
            System.out.println(getuser);
            System.out.println(getpass);
            System.out.println(pass2.getPassword());

            try
            {
                Connections conn = new Connections();
                String query = "Select * from login Where username = '"+getuser+"' And password = '"+getpass+"'";
                ResultSet result = conn.statement.executeQuery(query);

                if (result.next()==true)
                {
                    login.setVisible(false);
                    new Dashboard();

                }
                else {
                    JOptionPane.showMessageDialog(null,"This username or password dose not exit in our database.\nPlease check and Password & Username!");
                }

            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        } else if (e.getSource()==cancel)
        {
           setVisible(false);
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        new Login();

    }

}
