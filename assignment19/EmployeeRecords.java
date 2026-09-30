import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeRecords 
{

    public static void main(String[] args) throws Exception 
    {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String db = "jdbc:mysql://localhost:3306/employee";
        String user = "root";
        String password = "admin@123";

        try {
            Connection con = DriverManager.getConnection(db, user, password);

            System.out.println("Connection established");

            String query = "SELECT * FROM employee";

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\nEmployee Records");
            System.out.println("-------------------------");

            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("e_id"));
                System.out.println("Employee Name: " + rs.getString("e_name"));
                System.out.println("Employee Salary: " + rs.getDouble("e_sal"));
                System.out.println("-------------------------");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}