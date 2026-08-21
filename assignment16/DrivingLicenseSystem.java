import java.util.*;

class LicenseException extends Exception {

    LicenseException(String message) {
        super(message);
    }
}

class DrivingLicense {

    void checkEligibility(int age) throws LicenseException {

        if (age < 18) {
            throw new LicenseException(
                "Age is below 18. Not eligible for a driving license."
            );
        }

        System.out.println("User is eligible for a driving license.");
    }
}

public class DrivingLicenseSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            DrivingLicense d = new DrivingLicense();
            d.checkEligibility(age);
        }
        catch (LicenseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
