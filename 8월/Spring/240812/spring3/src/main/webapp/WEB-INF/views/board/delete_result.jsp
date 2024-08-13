
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>삭제 결과</title>
    <%
        String result = (String) request.getAttribute("result");
    %>
</head>
</head>
<body>
<h1>삭제 결과</h1>
<%=result %>

<h3>delete_result : ${result}</h3>
<hr color="red">
<a href="/board">
    <img src="../resources/image/board.png" width="300" height="200">
</a>
<a href="/">
    <img src="../resources/image/home.png" width="300" height="200">
</a>
<hr color="red">
</body>
</html>
