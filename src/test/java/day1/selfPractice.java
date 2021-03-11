package day1;

import utility.configurationReader;

import java.sql.*;

public class selfPractice {

    // static String url ="jdc:oracle:thin:@3.86.114.200:1521:XE";
    static String username = "hr";
    static String password = "hr";
    static String url = configurationReader.getProperty("database.url");

    static Connection conn;
    static Statement stm1;
    static ResultSet rs;

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@3.86.114.200:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(url, username, password);//connection

        Statement stm1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm1.executeQuery("select * from employees");

        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount(); // number of columns
        System.out.println(columnCount);
        int lastNameColumnNumber = 0;
        for (int i = 1; i <= columnCount; i++) {
            //System.out.printf("%-22s", rsmd.getColumnName(i));
            if (rsmd.getColumnName(i).equalsIgnoreCase("last_name")) {
                lastNameColumnNumber = i;
            }
        }
        System.out.println(lastNameColumnNumber);

        rs.beforeFirst(); //you are on row 1!

        int row = 1;
        while (rs.next()) {

            if (rs.getString(3).equalsIgnoreCase("austin")) {
                System.out.println(row);
            }
            row++;
        }

    }

}

