
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 가입 성공</title>
</head>
<body>
<%
    String result = (String)request.getAttribute("result");
%>
<h3>insert_result : <%= result %></h3>
<a href="login.do" >로그인 하기</a>
</body>
</html>
