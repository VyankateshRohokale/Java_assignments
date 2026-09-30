import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HospitalStaffLogin {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String db = "jdbc:mysql://localhost:3306/employee";
        String user = "root";
        String password = "admin@123";

        try {
            Connection con = DriverManager.getConnection(db, user, password);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter staff type (Doctor/Nurse): ");
            String staffType = sc.nextLine();

            System.out.print("Enter login ID: ");
            String loginId = sc.nextLine();

            System.out.print("Enter password: ");
            String pass = sc.nextLine();

            String query = "SELECT * FROM hospital_staff WHERE staff_type = ? AND login_id = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, staffType);
            ps.setString(2, loginId);
            ps.setString(3, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (staffType.equalsIgnoreCase("Doctor")) {
                    System.out.println("Doctor login successful");
                    System.out.println("Access granted to doctor portal");
                } else if (staffType.equalsIgnoreCase("Nurse")) {
                    System.out.println("Nurse login successful");
                    System.out.println("Access granted to nurse portal");
                }
            } else {
                System.out.println("Authentication failed");
                System.out.println("Invalid staff type, login ID or password");
            }

            rs.close();
            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
