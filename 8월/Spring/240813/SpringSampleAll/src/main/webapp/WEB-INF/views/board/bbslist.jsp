<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>게시물 목록</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            text-decoration: none;
            color: #007BFF;
        }
        a:hover {
            text-decoration: underline;
        }
        button {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
        button:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
<h1>게시물 목록</h1><br/>
<a href="${pageContext.request.contextPath}/board/new" class="btn">새 게시물 작성</a><br/><br/>
<table>
    <thead>
    <tr>
        <th>Seq</th>
        <th>Title</th>
        <th>Date</th>
        <th>Read Count</th>
        <th>Author</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="board" items="${boards}">
        <tr>
            <td>${board.seq}</td>
            <td>
                <a href="${pageContext.request.contextPath}/board/view/${board.seq}">${board.title}</a>
            </td>
            <td>${board.wdate}</td>
            <td>${board.readcount}</td>
            <td>${board.id}</td>
            <td>
                <a href="${pageContext.request.contextPath}/board/edit/${board.seq}">Edit</a>
                <form action="${pageContext.request.contextPath}/board/delete/${board.seq}" method="post" style="display:inline;">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
