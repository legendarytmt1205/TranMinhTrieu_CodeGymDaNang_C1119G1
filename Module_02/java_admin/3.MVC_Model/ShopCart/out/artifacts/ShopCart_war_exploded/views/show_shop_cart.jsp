<%@ page import="com.tmt.model.ItemCart" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
            width: 900px;
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
    <div class="row">
        <div class="col-12">
            <h1>Your Cart</h1>
            <a href="/products" class="btn btn-outline-warning">Home</a>

            <table class="table table-image">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Image</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Sum Price</th>
                </tr>
                </thead>
                <tbody>
                <%
                    float total = 0;
                    List<ItemCart> list;

                    if (session.getAttribute("item") != null) {
                        list = (List<ItemCart>) session.getAttribute("item");
                        for (ItemCart item : list) {
                            total = (float) (total + (item.getProduct().getPrice() * item.getQuantity()));
                            %>
                            <tr>
                                <td><a href="/cart?action=remove&productId=<%= item.getProduct().getId()%>" class="btn btn-danger">Delete</a></td>
                                <td> <h4><%= item.getProduct().getName()%></h4> </td>
                                <td class="w-25"><img src="<%= item.getProduct().getImage()%>" class="img-fluid img-thumbnail" alt="<%= item.getProduct().getName()%>"></td>
                                <td> <%= item.getProduct().getPrice()%></td>
                                <td> <%= item.getQuantity()%></td>
                                <td> <%= item.getProduct().getPrice() * item.getQuantity()%> </td>
                            </tr>
                            <%
                        }
                    }
                %>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><h3>Total: <%= total%> USD</h3></td>
                </tr>
                </tbody>

            </table>


        </div>
    </div>
</div>
</body>
</html>
</html>
