<%--
  Created by IntelliJ IDEA.
  User: koo
  Date: 24. 7. 25.
  Time: 오후 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  범위주석문
--%>
<html>
  <head>
    <title>jsp Test</title>
  </head>
  <body>
  <h3>index</h3>
  <br/>
  <a href="/hello">Hello Servlet으로 이동</a> <%--get--%>
  <br/><br/>

  <form action="/hello" method="post">
    <button type = "submit">Hello Servlet으로 이동</button>
  </form>

  <br/><br/>

  <button type="button" onclick="btnClick()">Hello Servlet으로 이동</button> <%--get--%>

  <script>

    function btnClick(){
      location.href = "/hello";
    }
  </script>

  </body>
</html>
