<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/4/2020
  Time: 12:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products List</title>
    <style>
        table {
            width: 900px;
            height: 200px;
            text-align: center;
            background-color: antiquewhite;
        }

        .head {
            background-color: aquamarine;
        }
    </style>
</head>
<body>
<h1>Products</h1>
<p>ACTION:
    <a href="/products?action=create">Create New Product</a>
</p>
<table border="1">
    <tr class="head">
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Suppliers</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td title="Display Information Product">product
                <a href="/products?action=view&id=${product.getProductId()}">${product.productName}</a>
            </td>
            <td>${product.productPrice}</td>
            <td>${product.productDesc}</td>
            <td>${product.supplier}</td>
            <td title="Edit Information Product"><a href="/products?action=edit&id=${product.getProductId()}">Edit</a>
            </td>
            <td title="Delete Information Product"><a
                    href="/products?action=delete&id=${product.getProductId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

