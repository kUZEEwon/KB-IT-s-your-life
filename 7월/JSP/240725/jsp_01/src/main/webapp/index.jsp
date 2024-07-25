<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<%
    // 자바 코드 조금
    out.println("jsp TEST");
%>
<br/>
<a href="login.jsp">로그인 처리</a><br/>
</body>
</html>