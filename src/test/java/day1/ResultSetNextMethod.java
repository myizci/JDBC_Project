package day1;

import java.sql.*;

public class ResultSetNextMethod {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@3.86.114.200:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stm1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm1.executeQuery("select * from regions");

        while(rs.next()){
            //System.out.println(rs.next()); // everytime next() method called, cursor will
            // move to next element
            System.out.println("rs.getString(1) = "+rs.getString(1));
        }
        // There are two ways to get cell data
        // 1. using column NAME for ResultSet object's getString(column NAME here)
        // 2. using column INDEX for ResultSet object's getString(column INDEX here)
       // SQL INDEX STARTS WITH 1 !!!!!!!





    }
}
