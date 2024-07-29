<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP - Hello World</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #2c3e50;
        }
        .links {
            margin-top: 20px;
        }
        .links a {
            text-decoration: none;
            color: #3498db;
        }
        .links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1><%= "Hello World!" %></h1>

<p>Current Date and Time: <%= new java.util.Date() %></p>

<div class="links">
    <a href="hello-servlet">Hello Servlet</a><br/>
    <a href="login.jsp">로그인</a><br/>
    <a href="insertUser.jsp">회원 가입</a><br/>
    <a href="listUser.do">전체 회원 목록</a><br/>
    <a href="check.jsp">check.jsp</a>
</div>



</body>
</html>
