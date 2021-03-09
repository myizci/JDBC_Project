package day1;

import java.sql.*;

public class ResultSetMetaData_ForColumnInfo {
    public static void main(String[] args) throws SQLException {


        String url = "jdbc:oracle:thin:@3.86.114.200:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stm1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm1.executeQuery("select * from countries");
        // ResultSet ONLY contain the data comes from the query result
        // It does not have any method to get information about columns
        // or columns datatype and so on
        //ResultSetMetaData, which is obtained by ResultSet object contains column information

        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        // we care about two methods
        //getColumnCount()
        //getColumnName or getColumnLabel() -- second one picks up alias
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(1));
        System.out.println(resultSetMetaData.getColumnName(2));
        System.out.println(resultSetMetaData.getColumnName(3));

        // print out all the column names
        System.out.println("==================");
        int columnCount = resultSetMetaData.getColumnCount();

        for(int col=1; col<=columnCount; col++){
            System.out.println("Column number  "+col +" name : "+resultSetMetaData.getColumnName(col));
        }


    }
}
