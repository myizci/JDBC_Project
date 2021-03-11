package utility;

import java.sql.*;

public class DB_Utility {
static private Connection conn;
static private Statement stm;
static private ResultSet rs;


    public static void createConnection(){

            String url = configurationReader.getProperty("database.url");
            String username = configurationReader.getProperty("database.username");
            String password = configurationReader.getProperty("database.password");;

        try {
             conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
        }

    }


    /*
    Create connection by JDBC url, username, and password
     */
    public static void createConnection(String url, String username, String password){

        try {
             conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
        }

    }


    public static ResultSet runQuery(String sql){
       try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
           System.out.println("Query works");
       }catch(SQLException e){
           System.out.println("Error Occurred while running query");
       }

       return rs;
    }




}
