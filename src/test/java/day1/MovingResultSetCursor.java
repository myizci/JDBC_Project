package day1;

import java.sql.*;

public class MovingResultSetCursor {

    public static void main(String[] args) throws SQLException {


        String url = "jdbc:oracle:thin:@3.86.114.200:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stm1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm1.executeQuery("select * from regions");
        /*
        These are the method of the ResultSet object we can use to move the cursor
        This will only work if your result is type scroll insensitive
        rs.next();
        rs.previous();
        rs.first();
        rs.last();
        rs.beforeFirst();
        rs.afterLast();

        rs.absolute(3); // it takes the cursor to a specific row, here 3
         */

        rs.first();
        System.out.println("First row : "+rs.getString(+2));
        rs.last();
        System.out.println("Second row : "+rs.getString(2));
        rs.previous();
        System.out.println("Previous row : "+rs.getString(2));
        rs.beforeFirst();

        while(rs.next()){
            System.out.println("2nd column data : "+ rs.getString(2));
        }
// after the loop the cursor is at after last
        if(rs.isAfterLast()){
            System.out.println("nothing will print at after last");
        }

rs.absolute(2);

        System.out.println("Second row region name is : "+rs.getString(2));



    }
}