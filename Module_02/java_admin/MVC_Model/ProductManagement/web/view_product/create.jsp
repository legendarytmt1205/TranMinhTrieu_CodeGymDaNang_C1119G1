<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/4/2020
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .mes{
            color:crimson;
            text-emphasis-color: lawngreen;
        }
    </style>
</head>
<body>
<h1>Create New Product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="mes">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back To Product List</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" id="description"></td>
            </tr>
            <tr>
                <td>Suppliers: </td>
                <td><input type="text" name="suppliers" id="suppliers"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
