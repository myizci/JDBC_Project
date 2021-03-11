package day1;

import utility.configurationReader;

import java.sql.*;

public class LibraryConnection {
    public static void main(String[] args) throws SQLException {

        String url      = configurationReader.getProperty("library1.database.url") ;
        String username = configurationReader.getProperty("library1.database.username") ;
        String password = configurationReader.getProperty("library1.database.password") ;

        Connection con = DriverManager.getConnection(url, username, password) ;
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet  rs  = stm.executeQuery("SELECT * FROM BOOKS") ;

        rs.next() ;
        System.out.println("rs.getString(2) = " + rs.getString(2) );

    }
}
