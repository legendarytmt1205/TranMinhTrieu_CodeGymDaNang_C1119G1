<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/4/2020
  Time: 12:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Product</title>
    <style>
        .message{
            color:red;
        }
    </style>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Search Product By Name</legend>
        <label>Name: </label>
        <input type="text" name="name" id="name">
        <input type="submit" value="Search">
    </fieldset>
</form>
<p>
    <a href="/products">Back To Product List</a>
</p>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getProductName()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope["product"].getProductPrice()}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${requestScope["product"].getProductDesc()}</td>
    </tr>
    <tr>
        <td>Suppliers: </td>
        <td>${requestScope["product"].getSupplier()}</td>
    </tr>
</table>
</body>
</html>
