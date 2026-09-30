import java.sql.Connection;
import java.sql.DriverManager;

public class StudentDatabaseConnection {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String db = "jdbc:mysql://localhost:3306/employee";
        String user = "root";
        String password = "admin@123";

        try {
            Connection con = DriverManager.getConnection(db, user, password);

            System.out.println("Student database connected successfully");

            con.close();

        } catch (Exception e) {
            System.out.println("Student database connection failed");
            System.out.println("Error: " + e.getMessage());
        }
    }
}