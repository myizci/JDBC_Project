import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {

        /*
        host: 3.86.114.200
        port: 1E
        username: hr
        password: hr

        jbdc url AKA connection string
        syntax:
        jdbc:vendorName:driverType@YourHost:Port:SID
        jdbc:oracle:oracle:thin@3.86.114.200:1521:XE
         */

        String connectionStr ="jdbc:oracle:thin:@3.86.114.200:1521:XE";
        String username ="hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(connectionStr,username,password);
            System.out.println("Connection SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("Connection FAILED"+e.getMessage());

        }
    }
}
