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
        "DELETE FROM Patient WHERE patient_id=?"
    );

    ps.setInt(1, Integer.parseInt(request.getParameter("id")));
    ps.executeUpdate();

    ps.close();
    con.close();

    response.sendRedirect("patient_index.jsp");
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
}
%>