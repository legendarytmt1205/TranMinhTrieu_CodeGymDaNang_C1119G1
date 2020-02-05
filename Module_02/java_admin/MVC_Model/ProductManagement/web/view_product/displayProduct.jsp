<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/4/2020
  Time: 12:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>Product Details</h1>
<p>
    <a href="/products">Back to product list</a>
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
