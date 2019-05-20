<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 20-05-2019
  Time: 06:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
<form action="updateStep2.do" method="post">
<center>
    <h2>Update Employee</h2>
    <br>
    &nbsp;

    <font size="4">
        Enter new details:<br><br>
        <table>
            <tr>
                <td>ID [${employee.id}]</td>
                <td><input type="text" name="id" value="${employee.id}" hidden="true" size="30"></td>
            </tr>
            <tr>
                <td>Name [${employee.name}]</td>
                <td><input type="text" name="name" size="30"></td>
            </tr>
            <tr>
                <td>Department [${employee.dept}]</td>
                <td><input type="text" name="dept" size="30"></td>
            </tr>
            <tr>
                <td>Salary [${employee.salary}]</td>
                <td><input type="text" name="salary" size="30"></td>
            </tr>
            <br>
            <tr>
                <td><input type="submit" value="UPDATE"></td>
            </tr>
        </table>
    </font>
</center>
</form>
</body>
</html>
