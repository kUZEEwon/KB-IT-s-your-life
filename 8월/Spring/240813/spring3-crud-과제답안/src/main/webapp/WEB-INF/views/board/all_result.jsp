<%@ page import="com.multi.spring3.board.domain.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container mt-5">
    <h1 class="text-center mb-4">Board List</h1>
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">No</th>
            <th scope="col">Title</th>
            <th scope="col">Content</th>
            <th scope="col">Writer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="board" items="${all}">
            <c:if test="${board != null}">
                <tr>
                    <th scope="row">${board.no}</th>
                    <td>${board.title}</td>
                    <td>${board.content}</td>
                    <td>${board.writer}</td>
                </tr>
            </c:if>
            <c:if test="${board == null}">
                <tr>
                    <td colspan="4" class="text-center">No boards found</td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <a href="/board" class="btn btn-primary mb-3">
            <img src="../resources/image/board.png" width="50" height="50" alt="Board Icon"> Go to Board
        </a>
        <a href="/" class="btn btn-secondary mb-3">
            <img src="../resources/image/home.png" width="50" height="50" alt="Home Icon"> Home
        </a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
