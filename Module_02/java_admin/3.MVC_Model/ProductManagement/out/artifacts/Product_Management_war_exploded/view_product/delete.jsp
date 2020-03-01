<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/4/2020
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting Product</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="/products">Back To Product List</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product Information</legend>
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
            <tr>
                <td><input type="submit" value="Delete Product"></td>
                <td><a href="/products">Back To Product List</a></td>
            </tr>
        </table>
    </fieldset>
</body>
</html>
