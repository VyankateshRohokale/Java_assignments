import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String db = "jdbc:mysql://localhost:3306/employee";
        String user = "root";
        String password = "admin@123";

        try {
            Connection con = DriverManager.getConnection(db, user, password);

            System.out.println("Database connection successful");

            con.close();

        } catch (Exception e) {
            System.out.println("Database connection failed");
            System.out.println("Error: " + e.getMessage());
        }
    }
}