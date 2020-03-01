<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/7/2020
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/dictionary" method="post">
    <label>Vietnamese dictionary</label>
    <br>
    <input type="text" name="key" value="${word}" id="word">
    <input type="submit" value="search" >
</form>
<div>
    <h1>Vietnamese Meaning: ${result}</h1>
</div>
</body>
</html>