import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LibraryManagementSystem extends JFrame {

    JTextField idField;
    JTextField titleField;
    JTextField authorField;
    JTextField priceField;
    JTable table;
    DefaultTableModel model;

    Connection con;

    public LibraryManagementSystem() {

        setTitle("Library Management System");
        setSize(800, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        connectDatabase();

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        formPanel.add(new JLabel("Book ID:"));
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        formPanel.add(titleField);

        formPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        formPanel.add(authorField);

        formPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        formPanel.add(priceField);

        JButton addButton = new JButton("Add Book");
        JButton updateButton = new JButton("Update Book");
        JButton deleteButton = new JButton("Delete Book");
        JButton clearButton = new JButton("Clear");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        model = new DefaultTableModel(
                new String[]{"Book ID", "Title", "Author", "Price"}, 0
        );

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        addButton.addActionListener(e -> addBook());
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());
        clearButton.addActionListener(e -> clearFields());

        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();

            if (row >= 0) {
                idField.setText(model.getValueAt(row, 0).toString());
                titleField.setText(model.getValueAt(row, 1).toString());
                authorField.setText(model.getValueAt(row, 2).toString());
                priceField.setText(model.getValueAt(row, 3).toString());
            }
        });

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        loadBooks();

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

    void addBook() {

        try {
            String query = "INSERT INTO books VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(idField.getText()));
            ps.setString(2, titleField.getText());
            ps.setString(3, authorField.getText());
            ps.setDouble(4, Double.parseDouble(priceField.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Book added successfully");

            ps.close();

            clearFields();
            loadBooks();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void updateBook() {

        try {
            String query = "UPDATE books SET title = ?, author = ?, price = ? WHERE book_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, titleField.getText());
            ps.setString(2, authorField.getText());
            ps.setDouble(3, Double.parseDouble(priceField.getText()));
            ps.setInt(4, Integer.parseInt(idField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Book updated successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Book not found");
            }

            ps.close();

            clearFields();
            loadBooks();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void deleteBook() {

        try {
            String query = "DELETE FROM books WHERE book_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(idField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Book deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Book not found");
            }

            ps.close();

            clearFields();
            loadBooks();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void loadBooks() {

        try {
            model.setRowCount(0);

            String query = "SELECT * FROM books";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price")
                });
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void clearFields() {
        idField.setText("");
        titleField.setText("");
        authorField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
}