<%--
  Created by IntelliJ IDEA.
  User: Tran Minh Trieu
  Date: 2/3/2020
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Trang Chu$</title>
    <style>
      #dis{
        border-radius: 5px;
        width: 300px;
        height: 50px;
        text-transform: uppercase;
        font-size: 20px;
      }
      #dis:hover{
          background-color:darkcyan;
      }
      .img{
        width: 800px;
        height: auto;
      }
    </style>
  </head>
  <body>
  <form action="customers">
    <input id="dis" type="submit" value="Display Customer List">
  </form>
  <div>
    <img class="img" src="https://dulichhoangphuong.com/wp-content/uploads/2019/08/15-%C4%91%E1%BB%8Ba-%C4%91i%E1%BB%83m-du-l%E1%BB%8Bch-H%C3%A0-Giang.jpg" alt="">
  </div>
  </body>
</html>
