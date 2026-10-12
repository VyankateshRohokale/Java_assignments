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
        "UPDATE Patient SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?"
    );

    ps.setString(1, request.getParameter("name"));
    ps.setInt(2, Integer.parseInt(request.getParameter("age")));
    ps.setString(3, request.getParameter("disease"));
    ps.setString(4, request.getParameter("status"));
    ps.setInt(5, Integer.parseInt(request.getParameter("id")));

    int rows = ps.executeUpdate();

    ps.close();
    con.close();

    response.sendRedirect("patient_index.jsp");
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
}
%>