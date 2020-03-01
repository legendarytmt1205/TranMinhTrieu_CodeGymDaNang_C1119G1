<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/13/2020
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TMT</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/home" method="post">
    <table>
        <tr>
            <td><input type="text" name="num1" value="${num1}"></td>
            <td><input type="text" name="num2" value="${num2}"></td>
        </tr>
        <tr>
            <td><input type="submit" name="operator" value="+" />Addition(+)</td>
            <td><input type="submit" name="operator" value="-"/>Subtraction(-)</td>
            <td><input type="submit" name="operator" value="*"/>Multiplication(x)</td>
            <td><input type="submit" name="operator" value="/"/>Division(/)</td>
        </tr>
        <tr><td>${result}</td></tr>
    </table>
</form>
</body>
</html>