<%@ page import="java.sql.*" %>
<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/PatientDB",
        "root",
        "admin@123"
    );

    PreparedStatement ps = con.prepareStatement(
        "INSERT INTO Patient VALUES (?, ?, ?, ?, ?)"
    );

    ps.setInt(1, Integer.parseInt(request.getParameter("id")));
    ps.setString(2, request.getParameter("name"));
    ps.setInt(3, Integer.parseInt(request.getParameter("age")));
    ps.setString(4, request.getParameter("disease"));
    ps.setString(5, request.getParameter("status"));

    ps.executeUpdate();

    ps.close();
    con.close();

    response.sendRedirect("patient_index.jsp");
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
}
%>