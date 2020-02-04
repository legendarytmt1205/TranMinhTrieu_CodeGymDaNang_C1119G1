<%@ page import="java.util.List" %>
<%@ page import="model.Customers" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/3/2020
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Customers List</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    List<Customers> list = Customers.getCustomers();
    request.setAttribute("abc", list);
%>
<div class="btn-customer">
    <h2 id="h2">Danh Sách Khách Hàng</h2>
    <a href="#" class="add-customer">Add Customer</a>
</div>
<div class="container">
    <br/>
    <table border="1" class="table">
        <thead>
        <tr>
            <th class="th">Họ Tên</th>
            <th class="th">Ngày Sinh</th>
            <th class="th">Địa Chỉ</th>
            <th class="th">Chức Năng</th>
        </tr>
        </thead>
        <tbody class="body">
        <c:forEach var="customer" items="${abc}">
            <tr>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.birthday}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td class="td-btn">
                    <a href="#" class="btn btnE" style="margin: 10px">Edit</a>
                    <a href="#" class="btn btnD" style="margin: 10px">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
