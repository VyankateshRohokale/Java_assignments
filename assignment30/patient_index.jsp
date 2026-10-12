<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Patient Management System</title>
</head>
<body>
    <h2>Patient Management System</h2>

    <form action="save_patient.jsp" method="post">
        Patient ID: <input type="number" name="id" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Age: <input type="number" name="age" min="0" required><br><br>
        Disease: <input type="text" name="disease" required><br><br>

        Treatment Status:
        <select name="status">
            <option value="Admitted">Admitted</option>
            <option value="Under Treatment">Under Treatment</option>
            <option value="Recovered">Recovered</option>
            <option value="Discharged">Discharged</option>
        </select><br><br>

        <input type="submit" value="Add Patient">
    </form>

    <h3>Patient Records</h3>

    <table border="1" cellpadding="8">
        <tr>
            <th>Patient ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Disease</th>
            <th>Treatment Status</th>
            <th>Actions</th>
        </tr>

        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/PatientDB",
                "root",
                "admin@123"
            );

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Patient");

            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("patient_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
            <td>
                <a href="edit_patient.jsp?id=<%= rs.getInt("patient_id") %>">Edit</a>
                |
                <a href="delete_patient.jsp?id=<%= rs.getInt("patient_id") %>" onclick="return confirm('Delete this patient?')">Delete</a>
            </td>
        </tr>
        <%
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            out.println("<tr><td colspan='6'>Error: " + e.getMessage() + "</td></tr>");
        }
        %>
    </table>
</body>
</html>