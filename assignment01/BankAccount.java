class BankAccount {
    int accountNumber;
    
    String accountHolder;
    double balance;

    // Default 
    BankAccount() {
        accountNumber = 1001;
        accountHolder = "Rahul";
        balance = 5000.0;
    }

    void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance : ₹" + balance);
    }

    public static void main(String[] args) {

        System.out.println("Java Environment Setup Successful!");

        String bankName = "State Bank of India";
        int branchCode = 101;
        double interestRate = 6.5;

        System.out.println("Bank Name : " + bankName);
        System.out.println("Branch Code : " + branchCode);
        System.out.println("Interest Rate : " + interestRate + "%");

        BankAccount account = new BankAccount();

        account.displayAccountDetails();
    }
}