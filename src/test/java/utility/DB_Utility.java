package utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Utility {
    static private Connection conn;
    static private Statement stm;
    static private ResultSet rs;
    private static ResultSetMetaData rsmd;


    public static void createConnection() {

        String url = configurationReader.getProperty("database.url");
        String username = configurationReader.getProperty("database.username");
        String password = configurationReader.getProperty("database.password");
        ;

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
        }

    }


    /*
    Create connection by JDBC url, username, and password
     */
    public static void createConnection(String url, String username, String password) {

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
        }

    }

    /*
    Run the given query "sql" and return ResultSet object that contains data
     */
    public static ResultSet runQuery(String sql) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            rsmd = rs.getMetaData();
            System.out.println("Query works");
        } catch (SQLException e) {
            System.out.println("Error Occurred while running query");
        }

        return rs;
    }

    public static void destroy() {
        try {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Error Occurred while destroy " + e.getMessage());
        }
    }

    public static int getRowCount() {
        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();
        } catch (SQLException e) {
            System.out.println("Error occurred while getRowCount " + e.getMessage());
        }
        return rowCount;
    }

    public static int getColumnCount() {
        int columnCount = 0;
        try {
            columnCount = rsmd.getColumnCount();
        } catch (SQLException e) {
            System.out.println("Error Occurred while getColumnCount " + e.getMessage());
        }
        return columnCount;
    }

    public static List<String> getALLColumnNamesAsList() {
        List<String> allColumnNames = new ArrayList<>();

        for (int i = 1; i <= getColumnCount(); i++) {
            try {
                allColumnNames.add(rsmd.getColumnName(i));
            } catch (SQLException e) {
                System.out.println("Error Occurred while getALLColumnNamesAsList " + e.getMessage());
            }

        }
        return allColumnNames;

    }


    //get entire row of data according to row number

    public static List<String> getRowDataAsList(int rowNum) {

        List<String> rowDataAsList = new ArrayList<>();

        try {
            rs.absolute(rowNum);
            for (int i = 1; i <= getColumnCount(); i++) {
                rowDataAsList.add(rs.getString(i));
            }


        } catch (SQLException e) {
            System.out.println("Error Occurred while getRowDataAsList " + e.getMessage());
        }


        return rowDataAsList;


    }


    public static String getCellValue(int rownum, int columnIndex) {

        String cellValue = "";
        try {
            rs.absolute(rownum);
            cellValue = rs.getString(columnIndex);

        } catch (SQLException e) {
            System.out.println("Error occured while getCellValue " + e.getMessage());
        }
        return cellValue;
    }

    public static String getCellValue(int rownum, String columnName) {

        String cellValue = "";
        try {
            rs.absolute(rownum);
            cellValue = rs.getString(columnName);

        } catch (SQLException e) {
            System.out.println("Error occured while getCellValue " + e.getMessage());
        }
        return cellValue;
    }



    public static List<String > getColumnDataAsList(int columnNum){

        List<String> columnDataList = new ArrayList<>();


           try {
               rs.beforeFirst();//make sure the cursor is at the before location
               while (rs.next()){
                   String cellValue= rs.getString(columnNum);
                   columnDataList.add(cellValue);

               }
               rs.beforeFirst();
           } catch (SQLException e) {
               System.out.println("Error occurred while getColumnDataAsList "+ e.getMessage());
           }





        return columnDataList;
    }

}
