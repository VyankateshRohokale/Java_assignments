import java.util.*;

class BankAccount {

    int balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    void withdraw(int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance = balance - amount;

        System.out.println("Withdrawal successful");
        System.out.println("New Balance: " + balance);
    }
}

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(1000);

        System.out.print("Enter withdrawal amount: ");
        int amount = sc.nextInt();

        try {
            account.withdraw(amount);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
