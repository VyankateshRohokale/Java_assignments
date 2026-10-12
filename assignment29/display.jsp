<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h2>Student Information</h2>

    <p>Name: <%= request.getParameter("name") %></p>
    <p>Roll Number: <%= request.getParameter("roll") %></p>
    <p>Course: <%= request.getParameter("course") %></p>
    <p>Marks: <%= request.getParameter("marks") %></p>
</body>
</html>