<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
<br>
<br>
<br>
<center>
    <h2><b>Employee Details</b></h2>
    <font size="5">
        <table border="1">
            <tr>
                <td>Name</td>
                <td>${employee.name}</td>
            </tr>
            <tr>
                <td>ID</td>
                <td>${employee.id}</td>
            </tr>
            <tr>
                <td>Department</td>
                <td>${employee.dept}</td>
            </tr>
            <tr>
                <td>Salary</td>
                <td>${employee.salary}</td>
            </tr>
        </table>
    </font>
</center>
</body>
</html>
