<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 1/28/2020
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <style>
    #content {
      width: 450px;
      margin: 100px auto;
      padding: 0 20px 20px;
      background-color:peru;
      border: solid navy 2px;
    }

    label {
      width: 10em;
      padding-right: .2em;
      margin-top: 5px;
      float: left;
      margin-left: 1em;
      font-weight: bold;
    }

    #data input {
      float: left;
      width: 20em;
      height: 2em;
      margin-bottom: 1em;
      border: 1px solid;
    }
    .sub{
      height: 40px;
      margin-bottom: 1em;
      border-radius: 10px;
      text-align: center;
      margin-left: 1.2em;
      background-color: #333333;
      color: #efefef;
    }
    .sub:hover{
      background-color: rebeccapurple;
    }
  </style>

</head>
<body>
<div id="content">
  <h1>Product Discount Calculator</h1>
  <form action="/result.jsp" method="post">
    <div id="data">
      <div>
        <label>Product Description:</label>
        <input type="text" name="description">
      </div>
      <div>
        <label>Price:</label>
        <input type="text" name="price">
      </div>
      <div>
        <label>Discount Percent:</label>
        <input type="text" name="discount">
      </div>
    </div>
    <div>
      <input title="Click open Discount" class="sub" type="submit" value="Discount Product">
    </div>
  </form>
</div>
</body>
</html>
