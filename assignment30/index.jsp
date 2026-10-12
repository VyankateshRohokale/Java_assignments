<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
    <h2>Employee Management System</h2>

    <form action="save.jsp" method="post">
        Employee ID: <input type="number" name="id" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Department: <input type="text" name="department" required><br><br>
        Salary: <input type="number" step="0.01" name="salary" required><br><br>
        <input type="submit" value="Add Employee">
    </form>

    <h3>Employee Records</h3>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Actions</th>
        </tr>

        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EmployeeDB",
                "root",
                "admin@123"
            );

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Employee");

            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("emp_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("department") %></td>
            <td><%= rs.getDouble("salary") %></td>
            <td>
                <a href="edit.jsp?id=<%= rs.getInt("emp_id") %>">Edit</a>
                |
                <a href="delete.jsp?id=<%= rs.getInt("emp_id") %>">Delete</a>
            </td>
        </tr>
        <%
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            out.println("<tr><td colspan='5'>" + e.getMessage() + "</td></tr>");
        }
        %>
    </table>
</body>
</html>