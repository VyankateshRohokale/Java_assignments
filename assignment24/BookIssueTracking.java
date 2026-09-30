import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookIssueTracking extends JFrame {

    JTextField bookIdField;
    JTextField studentNameField;
    JTextField issueDateField;
    JTextField returnDateField;

    JTable table;
    DefaultTableModel model;

    Connection con;

    public BookIssueTracking() {

        setTitle("Book Issue Tracking System");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        connectDatabase();

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        formPanel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        formPanel.add(bookIdField);

        formPanel.add(new JLabel("Student Name:"));
        studentNameField = new JTextField();
        formPanel.add(studentNameField);

        formPanel.add(new JLabel("Issue Date (YYYY-MM-DD):"));
        issueDateField = new JTextField();
        formPanel.add(issueDateField);

        formPanel.add(new JLabel("Return Date (YYYY-MM-DD):"));
        returnDateField = new JTextField();
        formPanel.add(returnDateField);

        JButton addButton = new JButton("Add Record");
        JButton updateButton = new JButton("Update Record");
        JButton deleteButton = new JButton("Delete Record");
        JButton clearButton = new JButton("Clear");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        model = new DefaultTableModel(
                new String[]{"Book ID", "Student Name", "Issue Date", "Return Date"}, 0
        );

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        addButton.addActionListener(e -> addRecord());
        updateButton.addActionListener(e -> updateRecord());
        deleteButton.addActionListener(e -> deleteRecord());
        clearButton.addActionListener(e -> clearFields());

        table.getSelectionModel().addListSelectionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {
                bookIdField.setText(model.getValueAt(row, 0).toString());
                studentNameField.setText(model.getValueAt(row, 1).toString());
                issueDateField.setText(model.getValueAt(row, 2).toString());
                returnDateField.setText(model.getValueAt(row, 3).toString());
            }
        });

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));

        topPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        loadRecords();

        setVisible(true);
    }

    void connectDatabase() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee",
                    "root",
                    "admin@123"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database connection failed: " + e.getMessage()
            );
        }
    }

    void addRecord() {

        try {

            String query = "INSERT INTO book_issue VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(bookIdField.getText()));
            ps.setString(2, studentNameField.getText());
            ps.setDate(3, Date.valueOf(issueDateField.getText()));
            ps.setDate(4, Date.valueOf(returnDateField.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Book issue record added successfully"
            );

            ps.close();

            clearFields();
            loadRecords();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
            );
        }
    }

    void updateRecord() {

        try {

            String query =
                    "UPDATE book_issue SET student_name = ?, issue_date = ?, return_date = ? WHERE book_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, studentNameField.getText());
            ps.setDate(2, Date.valueOf(issueDateField.getText()));
            ps.setDate(3, Date.valueOf(returnDateField.getText()));
            ps.setInt(4, Integer.parseInt(bookIdField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Book issue record updated successfully"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Record not found"
                );
            }

            ps.close();

            clearFields();
            loadRecords();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
            );
        }
    }

    void deleteRecord() {

        try {

            String query =
                    "DELETE FROM book_issue WHERE book_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(
                    1,
                    Integer.parseInt(bookIdField.getText())
            );

            int rows = ps.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Book issue record deleted successfully"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Record not found"
                );
            }

            ps.close();

            clearFields();
            loadRecords();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
            );
        }
    }

    void loadRecords() {

        try {

            model.setRowCount(0);

            String query = "SELECT * FROM book_issue";

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                model.addRow(
                        new Object[]{
                                rs.getInt("book_id"),
                                rs.getString("student_name"),
                                rs.getDate("issue_date"),
                                rs.getDate("return_date")
                        }
                );
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
            );
        }
    }

    void clearFields() {

        bookIdField.setText("");
        studentNameField.setText("");
        issueDateField.setText("");
        returnDateField.setText("");
    }

    public static void main(String[] args) {

        new BookIssueTracking();
    }
}