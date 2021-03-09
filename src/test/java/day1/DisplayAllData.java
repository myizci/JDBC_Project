package day1;

import java.sql.*;

public class DisplayAllData {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@3.86.114.200:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stm1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm1.executeQuery("select * from employees");

        //How to get move to the last row -->> rs.last()
        // HOw to get current row number -->> rs.getRow()

        rs.last();

        int rowNum = rs.getRow();
        // System.out.print("rowNum = " + rowNum);
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();


        // I want to print out entire first row of data in one line

//        for(int col=1; col<=columnCount; col++){
//
//            System.out.print(rs.getString(col) + "\t");
//
//        }
//        System.out.println();


        for (int col = 1; col <= resultSetMetaData.getColumnCount(); col++) {
            System.out.printf("%-22s", resultSetMetaData.getColumnName(col));
        }
        System.out.println();
        rs.beforeFirst(); // we go to first row
        while (rs.next()) {

            // this will print entire row
            for (int col = 1; col <= columnCount; col++) {
                System.out.printf("%-22s", rs.getString(col));

            }
            System.out.println();
        }
        rs.close();
        stm1.close();
        conn.close();

    }
}
