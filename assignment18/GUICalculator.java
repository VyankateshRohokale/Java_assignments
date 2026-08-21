import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUICalculator extends JFrame implements ActionListener {

    JTextField num1, num2;
    JButton add, subtract;
    JLabel result;

    GUICalculator() {

        setTitle("GUI Calculator");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        num1 = new JTextField();
        num2 = new JTextField();

        add = new JButton("Addition");
        subtract = new JButton("Subtraction");

        result = new JLabel("Result: ");

        add(new JLabel("First Number:"));
        add(num1);

        add(new JLabel("Second Number:"));
        add(num2);

        add(add);
        add(subtract);

        add(new JLabel(""));
        add(result);

        add.addActionListener(this);
        subtract.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());

        if (e.getSource() == add) {
            result.setText("Result: " + (a + b));
        }
        else if (e.getSource() == subtract) {
            result.setText("Result: " + (a - b));
        }
    }

    public static void main(String[] args) {

        new GUICalculator();
    }
}