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

      ResultSet result=  DB_Utility.runQuery("select * from regions");
      result.next();

            System.out.print(result.getString("REGION_NAME"));




    }
}
