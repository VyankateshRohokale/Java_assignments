<%@ page import="java.sql.*" %>
<%
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/EmployeeDB",
        "root",
        "admin@123"
    );

    ps = con.prepareStatement("SELECT * FROM Employee WHERE emp_id=?");
    ps.setInt(1, Integer.parseInt(request.getParameter("id")));
    rs = ps.executeQuery();

    if (rs.next()) {
%>
<html>
<body>
    <h2>Update Employee</h2>

    <form action="update.jsp" method="post">
        Employee ID:
        <input type="number" name="id" value="<%= rs.getInt("emp_id") %>" readonly><br><br>

        Name:
        <input type="text" name="name" value="<%= rs.getString("name") %>" required><br><br>

        Department:
        <input type="text" name="department" value="<%= rs.getString("department") %>" required><br><br>

        Salary:
        <input type="number" step="0.01" name="salary" value="<%= rs.getDouble("salary") %>" required><br><br>

        <input type="submit" value="Update Employee">
    </form>
</body>
</html>
<%
    } else {
        out.println("Employee not found.");
    }
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
} finally {
    if (rs != null) rs.close();
    if (ps != null) ps.close();
    if (con != null) con.close();
}
%>

