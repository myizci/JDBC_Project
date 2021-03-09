package day1;

import utility.configurationReader;

import javax.security.auth.login.Configuration;
import java.sql.*;

public class ConnectingByPropertiesFile {
    public static void main(String[] args) throws SQLException {
        String url = configurationReader.getProperty("database.url");
        String username = configurationReader.getProperty("database.username");
        String password = configurationReader.getProperty("database.password");

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stm1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm1.executeQuery("select * from employees");

        rs.next();
        System.out.println(rs.getString(2));
    }
}
