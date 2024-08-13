<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>모든 게시물 정보</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resources/css/out.css">
</head>
<body>
<div class="container">
    <h2>모든 게시물 정보</h2>
    <table>
        <thead>
        <tr>
            <th>순번</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="board" items="${all}">
            <c:if test="${board != null}">
                <tr>
                    <td>${board.no}</td>
                    <td>${board.title}</td>
                    <td>${board.content}</td>
                    <td>${board.writer}</td>
                </tr>
            </c:if>
            <c:if test="${board == null}">
                <tr>
                    <td colspan="4">No boards found</td>
                </tr>
            </c:if>
        </c:forEach>
        <tr>
            <td colspan="4">
                <hr color="red"/>
                <a href="/board">
                    <img src="../resources/image/board.png" width="300" height="200"/>
                </a>
                <a href="/">
                    <img src="../resources/image/home.png" width="300" height="200">
                </a>
                <hr color="red">
            </td>
        </tr>
        </tbody>
    </table>
</div>


</body>
</html>
