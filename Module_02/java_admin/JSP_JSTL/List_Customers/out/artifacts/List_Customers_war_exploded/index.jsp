<%@ page import="model.Customer" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 1/28/2020
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    List<Customer> list = Customer.getCustomers();
    request.setAttribute("tmt", list);
%>

<div class="container">
    <h2 id="h2">Danh Sách Khách Hàng</h2>
    <br/>
    <table border="1" class="table">
        <thead>
        <tr>
            <th class="th">Họ Tên</th>
            <th class="th">Ngày Sinh</th>
            <th class="th">Địa Chỉ</th>
            <th class="th">Hình Ảnh</th>
        </tr>
        </thead>
        <tbody class="body">
        <c:forEach var="customer" items="${tmt}">
            <tr>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.birthday}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td class="td"><img class="img" src="<c:out value="${customer.image}" />"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
