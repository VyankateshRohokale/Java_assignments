import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EmployeeRegistrationForm extends JFrame {
    JTextField idField, nameField, departmentField, salaryField;
    JButton submitButton;
    EmployeeRegistrationForm() {
        setTitle("Employee Registration Form");
        setSize(450, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        JLabel idLabel = new JLabel("Employee ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel departmentLabel = new JLabel("Department:");
        JLabel salaryLabel = new JLabel("Salary:");
        idField = new JTextField();
        nameField = new JTextField();
        departmentField = new JTextField();
        salaryField = new JTextField();
        submitButton = new JButton("Register");

        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(departmentLabel);
        add(departmentField);
        add(salaryLabel);
        add(salaryField);
        add(new JLabel(""));
        add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                    EmployeeRegistrationForm.this,
                    "Employee Details\n"
                    + "Employee ID: " + idField.getText()
                    + "\nName: " + nameField.getText()
                    + "\nDepartment: " + departmentField.getText()
                    + "\nSalary: " + salaryField.getText()
                );
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new EmployeeRegistrationForm();
    }
}