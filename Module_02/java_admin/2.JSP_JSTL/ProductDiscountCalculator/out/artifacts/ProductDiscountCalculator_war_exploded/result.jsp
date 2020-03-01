<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 1/28/2020
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
    String description = request.getParameter("description");
    float price = Float.parseFloat(request.getParameter("price"));
    int percent = Integer.parseInt(request.getParameter("discount"));
    float discount = (float) (price*percent*0.01);
    float total = price - discount;
%>
    <h3>Product Description: <%=description%></h3>
    <h3>Product Price: <%=price%></h3>
    <h3>Product Percent: <%=percent%></h3>
    <h3>Product Discount: <%=discount%></h3>
    <h3>Product Total: <%=total%></h3>
</body>
</html>
