import java.sql.*;

public class TestConnection {



    public static void main(String[] args) {



        String connectionStr ="jdbc:oracle:thin:@3.86.114.200:1521:XE";
        String username ="hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(connectionStr,username,password);

            Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = st1.executeQuery("SELECT * FROM REGIONS");

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
            System.out.println("Connection FAILED"+e.getMessage());

        }
    }
}
