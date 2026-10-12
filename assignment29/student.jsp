<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
    <h2>Enter Student Information</h2>

    <form action="display.jsp" method="post">
        Name: <input type="text" name="name" required><br><br>
        Roll Number: <input type="text" name="roll" required><br><br>
        Course: <input type="text" name="course" required><br><br>
        Marks: <input type="number" name="marks" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>