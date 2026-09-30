import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentCRUD {

    static Connection con;

    static void insertStudent(Scanner sc) throws Exception {
        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        String query = "INSERT INTO student VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, rollNo);
        ps.setString(2, name);
        ps.setString(3, course);
        ps.setDouble(4, marks);

        ps.executeUpdate();

        System.out.println("Student inserted successfully");

        ps.close();
    }

    static void displayStudents() throws Exception {
        String query = "SELECT * FROM student";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        System.out.println("\nStudent Records");
        System.out.println("-------------------------");

        while (rs.next()) {
            System.out.println("Roll Number: " + rs.getInt("roll_no"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Course: " + rs.getString("course"));
            System.out.println("Marks: " + rs.getDouble("marks"));
            System.out.println("-------------------------");
        }

        rs.close();
        ps.close();
    }

    static void updateStudent(Scanner sc) throws Exception {
        System.out.print("Enter Roll Number to update: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Course: ");
        String course = sc.nextLine();

        System.out.print("Enter New Marks: ");
        double marks = sc.nextDouble();

        String query = "UPDATE student SET name = ?, course = ?, marks = ? WHERE roll_no = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, name);
        ps.setString(2, course);
        ps.setDouble(3, marks);
        ps.setInt(4, rollNo);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Student not found");
        }

        ps.close();
    }

    static void deleteStudent(Scanner sc) throws Exception {
        System.out.print("Enter Roll Number to delete: ");
        int rollNo = sc.nextInt();

        String query = "DELETE FROM student WHERE roll_no = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, rollNo);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Student not found");
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
            System.out.println("\n===== Student CRUD =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        insertStudent(sc);
                        break;

                    case 2:
                        displayStudents();
                        break;

                    case 3:
                        updateStudent(sc);
                        break;

                    case 4:
                        deleteStudent(sc);
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