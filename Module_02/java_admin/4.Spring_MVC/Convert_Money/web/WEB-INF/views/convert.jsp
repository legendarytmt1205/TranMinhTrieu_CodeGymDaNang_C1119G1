<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/7/2020
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form action="/convert" method="post">
    <label>TỈ GIÁ HIỆN TẠI: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="${rate}"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="${usd}"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
    <h1>VND:  ${result} </h1>
</form>
</body>
</html>
