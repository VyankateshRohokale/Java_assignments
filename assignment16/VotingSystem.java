import java.util.*;

class AgeException extends Exception {

    AgeException(String message) {
        super(message);
    }
}

class Voting {

    void checkAge(int age) throws AgeException {

        if (age < 18) {
            throw new AgeException("Age is below 18. Not eligible for voting.");
        }

        System.out.println("User is eligible for voting.");
    }
}

public class VotingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            Voting v = new Voting();
            v.checkAge(age);
        }
        catch (AgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
