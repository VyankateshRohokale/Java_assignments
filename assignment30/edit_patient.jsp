<%@ page import="java.sql.*" %>
<%
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/PatientDB",
        "root",
        "admin@123"
    );

    ps = con.prepareStatement(
        "SELECT * FROM Patient WHERE patient_id=?"
    );

    ps.setInt(1, Integer.parseInt(request.getParameter("id")));
    rs = ps.executeQuery();

    if (rs.next()) {
        int id = rs.getInt("patient_id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String disease = rs.getString("disease");
        String status = rs.getString("treatment_status");
%>
<html>
<head>
    <title>Edit Patient</title>
</head>
<body>
    <h2>Update Patient Details</h2>

    <form action="update_patient.jsp" method="post">
        Patient ID:
        <input type="number" name="id" value="<%= id %>" readonly><br><br>

        Name:
        <input type="text" name="name" value="<%= name %>" required><br><br>

        Age:
        <input type="number" name="age" value="<%= age %>" min="0" required><br><br>

        Disease:
        <input type="text" name="disease" value="<%= disease %>" required><br><br>

        Treatment Status:
        <select name="status">
            <option value="Admitted" <%= status.equals("Admitted") ? "selected" : "" %>>Admitted</option>
            <option value="Under Treatment" <%= status.equals("Under Treatment") ? "selected" : "" %>>Under Treatment</option>
            <option value="Recovered" <%= status.equals("Recovered") ? "selected" : "" %>>Recovered</option>
            <option value="Discharged" <%= status.equals("Discharged") ? "selected" : "" %>>Discharged</option>
        </select><br><br>

        <input type="submit" value="Update Patient">
    </form>
</body>
</html>
<%
    } else {
        out.println("Patient not found.");
    }
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
} finally {
    if (rs != null) try { rs.close(); } catch (SQLException e) {}
    if (ps != null) try { ps.close(); } catch (SQLException e) {}
    if (con != null) try { con.close(); } catch (SQLException e) {}
}
%>