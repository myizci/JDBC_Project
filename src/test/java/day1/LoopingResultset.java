package day1;

import javax.xml.transform.Result;
import java.sql.*;

public class LoopingResultset {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@3.86.114.200:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stm1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stm1.executeQuery("select * from regions");
            // next method will move your cursor to the next lin
            // and also, return true if you have more rows and return false if there is no row
            //rs.next();
            //System.out.println("Region Value at this row "+ rs.getString("Region_Name"));
            //Checking if there is next row or not



//            while (rs.next()) {
//                System.out.println("Region ID at the row " + rs.getString("Region_ID"));
//                System.out.println("Job values" + rs.getString("Job_title"));
//            }

            // Create a new ResultSet  by running a different query like
            // Select * from Jobs


            rs = stm1.executeQuery("select * from jobs");

            while(rs.next()){
                System.out.print(rs.getString(1)+" : ");
                System.out.print(rs.getString(2));
                System.out.println();
                System.out.println("---------------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error occured" + e.getMessage());
        }
    }
}
