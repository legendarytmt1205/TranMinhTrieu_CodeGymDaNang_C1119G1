<%-- 
    Document   : products
    Created on : Aug 11, 2019, 12:48:04 AM
    Author     : Trung
--%>

<%@page import="entity.ItemCart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
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
                    <h1>List Products</h1>
                    <%
                        int item = 0;
                        if (session.getAttribute("cart") != null) {
                            List<ItemCart> listItem = (List<ItemCart>) session.getAttribute("cart");
                            for (ItemCart elem : listItem) {
                                    item = item + elem.getQuatity();
                                }
                       
                        }

                    %>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-8">
                                <a href="/demo/cart" class="btn btn-outline-secondary">Your Cart: <%= item%></a>
                            </div>
                            <div class="col-md-4">
                                <form class="form-inline" action="/demo/products" method="post">
                                    <input type="text" name="s" class="form-control">
                                    <input type="submit" value="Search" class="btn btn-primary">
                                </form>
                            </div>
                        </div>
                    </div>


                    <table class="table table-image">
                        <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Image</th>
                                <th scope="col">Price</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Product> list = new ArrayList<>();
                                list = (List<Product>) request.getAttribute("listProducts");
                                for (Product p : list) {
                            %>
                            <tr>
                                <th scope="row"><%= p.getName()%></th>
                                <td class="w-25">
                                    <img src="<%= p.getImageURL()%>" class="img-fluid img-thumbnail" alt="<%= p.getName()%>">
                                </td>
                                <td><%= p.getPrice()%></td>
                                <td><a href="/demo/cart?action=buy&productId=<%= p.getId()%>" class="btn btn-outline-success">Buy</a></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>   
                </div>
            </div>
        </div>
    </body>
</html>
