<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/12/2020
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>TMT</title>
</head>
<body>
<h3>Sandwich Condiments</h3>
<form:form action="/save" method="POST" >
  <table>
    <tr>
      <td><input type="checkbox" name="list" value="Lettuce">Lettuce</td>
      <td><input type="checkbox" name="list" value="Tomato">Tomato</td>
      <td><input type="checkbox" name="list" value="Mustard">Mustard</td>
      <td><input type="checkbox" name="list" value="Sprouts">Sprouts</td>
    </tr>
    <tr><td><input type="submit" value="save"></td></tr>
  </table>
</form:form>
</body>
</html>