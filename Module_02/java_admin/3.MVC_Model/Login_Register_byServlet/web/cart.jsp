<%-- 
    Document   : cart
    Created on : Aug 11, 2019, 7:13:32 PM
    Author     : Trung
--%>

<%@page import="entity.Product"%>
<%@page import="entity.ItemCart"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <style>
            .container {
                padding: 2rem 0rem;
            }

            h4 {
                margin: 2rem 0rem 1rem;
            }

            .table-image td,th {
                vertical-align: middle;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Your Cart</h1>
                    <a href="/demo/products" class="btn btn-outline-warning">Home</a>

                    <table class="table table-image">
                        <thead>
                            <tr>
                                <th scope="col">Action</th>
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
                                List<ItemCart> list = new ArrayList<ItemCart>();

                                if (session.getAttribute("cart") != null) {
                                    list = (List<ItemCart>) session.getAttribute("cart");
                                    for (ItemCart item : list) {
                                        total = total + (item.getProduct().getPrice() * item.getQuatity());


                            %>
                            <tr>
                                <td><a href="/demo/cart?action=remove&productId=<%= item.getProduct().getId()%>" class="btn btn-danger">Delete</a></td>
                                <td> <h4><%= item.getProduct().getName()%></h4> </td>
                                <td class="w-25"><img src="<%= item.getProduct().getImageURL()%>" class="img-fluid img-thumbnail" alt="<%= item.getProduct().getName()%>"></td>
                                <td> <%= item.getProduct().getPrice()%></td>
                                <td> <%= item.getQuatity()%></td>
                                <td> <%= item.getProduct().getPrice() * item.getQuatity()%> </td>
                            </tr>  
                            <%
                                }
                                }
                            %>
                            <tr>
                                <td><a href="#" style="float: right" class="btn btn-primary">PayMent</a></td>
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
