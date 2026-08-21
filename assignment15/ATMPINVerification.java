import java.util.*;

class ATMSystem {

    void verifyPIN(int pin) {

        if (pin != 1234) {
            throw new IllegalArgumentException("Invalid PIN");
        }

        System.out.println("PIN verified successfully");
    }
}

public class ATMPINVerification {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        try {
            ATMSystem atm = new ATMSystem();
            atm.verifyPIN(pin);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("PIN verification process completed.");
        }

        sc.close();
    }
}
