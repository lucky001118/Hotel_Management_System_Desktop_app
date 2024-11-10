package hotelmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connections {
    public Object connection;
    public Statement statement;

    public Connections() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/hotelmanagementsystem";

            String username = "root";
            String pass = "Lucky@server2002";
            Connection connection = DriverManager.getConnection(url, username, pass);
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Connections();
    }

}
