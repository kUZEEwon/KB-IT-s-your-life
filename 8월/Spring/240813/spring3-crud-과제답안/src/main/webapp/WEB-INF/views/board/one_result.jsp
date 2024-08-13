<%@ page import="com.multi.spring3.board.domain.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board Details</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

    <%
    BoardVO boardVO = (BoardVO) request.getAttribute("boardVO");
%>
<div class="container mt-5">

    <h2 class="text-center mb-4">Board Details</h2>
    <c:if test="${not empty sessionScope.login_id}">
    <div class="text-right mb-3">
        <a href="logout" class="btn btn-danger">Logout</a>
    </div>
    </c:if>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Field</th>
            <th scope="col">Value</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>No</td>
            <td><%= boardVO.getNo() %></td>
        </tr>
        <tr>
            <td>Title</td>
            <td><%= boardVO.getTitle() %></td>
        </tr>
        <tr>
            <td>Content</td>
            <td><%= boardVO.getContent() %></td>
        </tr>
        <tr>
            <td>Writer</td>
            <td><%= boardVO.getWriter() %></td>
        </tr>
        <tr>
            <td colspan="2" class="text-center">
                <hr class="my-4" style="border-top: 1px solid red;"
