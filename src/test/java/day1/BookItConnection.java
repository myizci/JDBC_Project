package day1;

import utility.configurationReader;

import java.sql.*;

public class BookItConnection {
    public static void main(String[] args) throws SQLException {

        String url = configurationReader.getProperty("bookit.url");
        String username = configurationReader.getProperty("bookit.username");
        String password = configurationReader.getProperty("bookit.password");

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stm1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm1.executeQuery("select * from room");

        rs.next();
        System.out.println(rs.getString(2));

    }

}
