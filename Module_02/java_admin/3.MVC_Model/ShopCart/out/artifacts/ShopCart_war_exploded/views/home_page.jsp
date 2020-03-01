<%@ page import="com.tmt.model.ItemCart" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/5/2020
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        .container {
            width: 1170px;
            margin: 0 90px
        }

        .form-group-s a {
            margin-left: 5px;
        }

        .form-group {
            float: right;
            margin-right: -62px;
        }

        .container-form {
            margin: 22px 107px;
        }

        .table {
            width: 1200px;
        }

        .table-bordered {
            text-align: center;
        }

        .form-control {
            width: 200px;
        }
        .imgProduct{
            width: 150px;
            height: 200px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>LIST PRODUCTS</h1>
    <p>WELCOME SHOPPING THE WORLD</p>
    <%
        int item = 0;
        if (session.getAttribute("cart") != null) {
            List<ItemCart> listItem = (List<ItemCart>) session.getAttribute("cart");
            for (ItemCart elem : listItem) {
                item = item + elem.getQuantity();
            }
        }
    %>
    <form class="form-inline">
        <div class="form-group-s">
            <label>ShopCart: </label>
            <a href="/item">Quantity</a>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="search" placeholder="Enter product name" name="search">
            <button type="submit" class="btn btn-default">Search</button>
        </div>
    </form>
</div>
<div class="container-form">
    <h2>Product Table</h2>
    <table class="table table-bordered">
        <thead>
        <tr class="tr-head">
            <th style="text-align: center">Product Name</th>
            <th style="text-align: center">Product Image</th>
            <th style="text-align: center">Product Price</th>
            <th style="text-align: center"><p>Buy</p></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${requestScope["products"]}' var="product">
            <tr>
                <td>${product.name}</td>
                <td><img class="imgProduct" src="<c:out value="${product.image}"/>"/></td>
                <td>${product.price}</td>
                <td title="Click To Buy Product">
                    <a href="/products?action=buy&id=${product.getId()}">Buy</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
</html>
