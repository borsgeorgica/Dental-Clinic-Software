package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static Connection con = null;

    private static String db = "team014";
    private static String user = "team014";
    private static String pass = "19955607";

    public static Connection getConnection() {
        if (con != null)
            return con;

        return getConnection(db, user, pass);
    }

    private static Connection getConnection(String db_name, String user_name, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(
                    "jdbc:mysql://stusql.dcs.shef.ac.uk/" + db_name + "?user=" + user_name + "&password=" + password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void closeConnection() {
        try {
            con.close();
            System.out.println("Connection closed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the db
     */
    public static String getDb() {
        return db;
    }

}