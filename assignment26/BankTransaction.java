class BankAccount {
    int balance = 10000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class DepositTask implements Runnable {
    BankAccount account;

    DepositTask(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(500);
        }
    }
}

class WithdrawTask implements Runnable {
    BankAccount account;

    WithdrawTask(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(300);
        }
    }
}

public class BankTransaction {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new DepositTask(account));
        Thread t2 = new Thread(new WithdrawTask(account));

        t1.start();
        t2.start();
    }
}