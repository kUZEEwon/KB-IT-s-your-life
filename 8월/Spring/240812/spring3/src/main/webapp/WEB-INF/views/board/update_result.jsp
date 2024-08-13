
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 수정 결과</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resources/css/out.css">
    <%
        String result = (String) request.getAttribute("result");
    %>
</head>
<body>
<h1>글 수정 결과</h1>
<h3>update_result : ${result}</h3>
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
