import java.util.*;

class LoginSystem {

    void login(String password) {

        if (!password.equals("java123")) {
            throw new IllegalArgumentException("Invalid password");
        }

        System.out.println("Login successful");
    }
}

public class Login {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            LoginSystem l = new LoginSystem();
            l.login(password);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Login verification completed.");
        }

        sc.close();
    }
}
