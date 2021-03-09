package day1;

import java.sql.*;

public class JDBC_FirstStep {
    public static void main(String[] args) {

        String url ="jdbc:oracle:thin:@3.86.114.200:1521:XE";
        String username ="hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            // this way of creating a statement allows us to move forward and backward easily and
            // navigating through the result
            Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = st1.executeQuery("SELECT * FROM REGIONS");
            // In order to access resultset, we need tot know which we row we are at
            // before entering the first row, the cursor of the resultset is at the location as -- before first
            //in order to move to next line , we need to call next method of result set
            //in order to get any colUmn data, we need to call method get string or get Double.... and so on

            rs.next();
            // now we are at the first row
            System.out.println("FIRST ROW REGION_NAME IS "+rs.getString("REGION_NAME"));
            rs.next();
            System.out.println("SECOND ROW REGION_NAME IS "+rs.getString("REGION_NAME"));
            rs.next();
            System.out.println("THIRD ROW REGION_NAME IS "+rs.getString("REGION_NAME"));
            rs.next();
            System.out.println("FOURTH ROW REGION_NAME IS "+rs.getString("REGION_NAME"));
            rs.next(); // this will move the cursor the location known as -- AFTER LAST
            // BELOW LINE WILL NOT WORK
            // System.out.println("FIFTH ROW REGION_NAME IS "+rs.getString("REGION_NAME"));

            System.out.println("Connection SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("Error Occured "+e.getMessage());

        }
    }
}
