package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbContext {
    public DbContext() {
        System.out.println("Opened database successfully");
    }

    public static Connection getConnection()
    {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection(DBCredentials.url,
                            DBCredentials.user, DBCredentials.password);
            c.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return c;
    }

    public static void ExecuteQuerry(String sql){
        Connection connection = DbContext.getConnection();
        Statement stm = null;
        try {
            stm = connection.createStatement();
            stm.executeUpdate(sql);
            connection.commit();
            stm.close();
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}