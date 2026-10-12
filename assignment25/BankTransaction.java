class DepositThread extends Thread {
    static int balance = 10000;

    public void run() {
        for (int i = 0; i < 5; i++) {
            deposit(500);
        }
    }

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + balance);
    }
}

class WithdrawThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdraw(300);
        }
    }

    synchronized void withdraw(int amount) {
        if (DepositThread.balance >= amount) {
            DepositThread.balance -= amount;
            System.out.println("Withdrawn: " + amount + " | Balance: " + DepositThread.balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

public class BankTransaction {
    public static void main(String[] args) {
        DepositThread obj1 = new DepositThread();
        WithdrawThread obj2 = new WithdrawThread();

        obj1.start();
        obj2.start();
    }
}