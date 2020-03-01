<%--<%@ page import="model.Customer" %>--%>
<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>
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
    List<Customer> listCustomer = Customer.getListCustomers();
    request.setAttribute("CusList", listCustomer);
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
        <c:forEach var="cus" items="${CusList}">
            <tr>
                <td><c:out value="${cus.name}"/></td>
                <td><c:out value="${cus.birthday}"/></td>
                <td><c:out value="${cus.address}"/></td>
                <td class="td"><c:out value="${cus.image}"/>"</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
