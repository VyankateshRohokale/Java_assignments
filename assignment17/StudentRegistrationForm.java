import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame {

    JTextField nameField, rollField, courseField;
    JButton submitButton;

    StudentRegistrationForm() {

        setTitle("Student Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel nameLabel = new JLabel("Student Name:");
        JLabel rollLabel = new JLabel("Roll Number:");
        JLabel courseLabel = new JLabel("Course:");

        nameField = new JTextField();
        rollField = new JTextField();
        courseField = new JTextField();

        submitButton = new JButton("Register");
        add(nameLabel);
        add(nameField);
        add(rollLabel);
        add(rollField);
        add(courseLabel);
        add(courseField);

        add(new JLabel(""));
        add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(
                    StudentRegistrationForm.this,
                    "Student Registered Successfully\n"
                    + "Name: " + nameField.getText()
                    + "\nRoll Number: " + rollField.getText()
                    + "\nCourse: " + courseField.getText()
                );
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {

        new StudentRegistrationForm();
    }
}