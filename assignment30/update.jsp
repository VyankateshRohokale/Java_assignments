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
        "UPDATE Employee SET name=?, department=?, salary=? WHERE emp_id=?"
    );

    ps.setString(1, request.getParameter("name"));
    ps.setString(2, request.getParameter("department"));
    ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
    ps.setInt(4, Integer.parseInt(request.getParameter("id")));

    ps.executeUpdate();

    ps.close();
    con.close();

    response.sendRedirect("index.jsp");
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
}
%>