
import java.sql.Connection;

public class testDB {
    public static void main(String[] arg) {

        Connection myConn = null;

        try {
            //get connection to database
            myConn = ConnectionConfig.getConnection();
            if (myConn != null) {
                System.out.println("Connection established");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
