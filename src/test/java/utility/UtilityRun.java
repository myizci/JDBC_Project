package utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityRun {
    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection(
                configurationReader.getProperty("database.url"),
                configurationReader.getProperty("database.username"),
                configurationReader.getProperty("database.password")
        );

        ResultSet result = DB_Utility.runQuery("select * from regions");
        result.next();

        System.out.print(result.getString("REGION_NAME"));
        System.out.println();
        System.out.println(DB_Utility.getRowCount());
        System.out.println(DB_Utility.getColumnCount());
        System.out.println(DB_Utility.getALLColumnNamesAsList());
        System.out.println(DB_Utility.getRowDataAsList(2));
        System.out.println(DB_Utility.getCellValue(3, 2));
        System.out.println(DB_Utility.getCellValue(3, "\"REGION_NAME\""));
        DB_Utility.destroy();

    }
}
