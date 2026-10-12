<%@ page import="java.sql.*" %>
<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/EmployeeDB",
        "root",
        "admin@123"
    );

    PreparedStatement ps = con.prepareStatement(
        "INSERT INTO Employee VALUES (?, ?, ?, ?)"
    );

    ps.setInt(1, Integer.parseInt(request.getParameter("id")));
    ps.setString(2, request.getParameter("name"));
    ps.setString(3, request.getParameter("department"));
    ps.setDouble(4, Double.parseDouble(request.getParameter("salary")));

    ps.executeUpdate();

    ps.close();
    con.close();

    response.sendRedirect("index.jsp");
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
}
%>