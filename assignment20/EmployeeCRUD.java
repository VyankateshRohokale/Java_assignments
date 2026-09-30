import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeeCRUD {

    static Connection con;

    static void insertEmployee(Scanner sc) throws Exception {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        String query = "INSERT INTO employee VALUES (?, ?)";

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO employee (e_id, e_name, e_sal) VALUES (?, ?, ?)"
        );

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, salary);

        ps.executeUpdate();

        System.out.println("Employee inserted successfully");

        ps.close();
    }

    static void displayEmployees() throws Exception {
        String query = "SELECT * FROM employee";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        System.out.println("\nEmployee Records");
        System.out.println("-------------------------");

        while (rs.next()) {
            System.out.println("Employee ID: " + rs.getInt("e_id"));
            System.out.println("Employee Name: " + rs.getString("e_name"));
            System.out.println("Employee Salary: " + rs.getDouble("e_sal"));
            System.out.println("-------------------------");
        }

        rs.close();
        ps.close();
    }

    static void updateEmployee(Scanner sc) throws Exception {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Employee Salary: ");
        double salary = sc.nextDouble();

        String query = "UPDATE employee SET e_name = ?, e_sal = ? WHERE e_id = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, name);
        ps.setDouble(2, salary);
        ps.setInt(3, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Employee updated successfully");
        } else {
            System.out.println("Employee not found");
        }

        ps.close();
    }

    static void deleteEmployee(Scanner sc) throws Exception {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM employee WHERE e_id = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("Employee not found");
        }

        ps.close();
    }

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String db = "jdbc:mysql://localhost:3306/employee";
        String user = "root";
        String password = "admin@123";

        con = DriverManager.getConnection(db, user, password);

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== Employee CRUD =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        insertEmployee(sc);
                        break;

                    case 2:
                        displayEmployees();
                        break;

                    case 3:
                        updateEmployee(sc);
                        break;

                    case 4:
                        deleteEmployee(sc);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        con.close();
        sc.close();
    }
}
