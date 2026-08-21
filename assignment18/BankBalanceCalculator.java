import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BankBalanceCalculator extends JFrame implements ActionListener {
    JTextField balanceField, transactionField;
    JButton deposit, withdraw;
    JLabel result;
    double balance;
    BankBalanceCalculator() {
        setTitle("Bank Balance Calculator");
        setSize(450, 300);
        setLayout(new GridLayout(4, 2, 10, 10));
        balanceField = new JTextField();
        transactionField = new JTextField();

        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");

        result = new JLabel("Updated Balance: ");

        add(new JLabel("Initial Balance:"));
        add(balanceField);

        add(new JLabel("Transaction Amount:"));
        add(transactionField);

        add(deposit);
        add(withdraw);

        add(new JLabel(""));
        add(result);

        deposit.addActionListener(this);
        withdraw.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        balance = Double.parseDouble(balanceField.getText());

        double amount =
            Double.parseDouble(transactionField.getText());

        if (e.getSource() == deposit) {

            balance = balance + amount;

        }
        else if (e.getSource() == withdraw) {

            balance = balance - amount;
        }

        result.setText("Updated Balance: " + balance);
    }

    public static void main(String[] args) {

        new BankBalanceCalculator();
    }
}