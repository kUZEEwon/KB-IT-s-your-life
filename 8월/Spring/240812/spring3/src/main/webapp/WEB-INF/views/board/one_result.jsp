<%@ page import="com.multi.spring3.member.domain.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Member CRUD Form</title>
    <link rel="stylesheet" href="../resources/css/out.css">
</head>
<body>
<%
    BoardVO boardVO = (BoardVO) request.getAttribute("boardVO");
%>
<div class="container">
    <h2>작성한 게시글 확인</h2>
    <table>
        <thead>
        <tr>
            <th>항목명</th>
            <th>항목값</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>글 순번</td>
            <td><%=boardVO.getNo()%></td>
        </tr>
        <tr>
            <td>글 제목</td>
            <td><%=boardVO.getTitle()%></td>
        </tr>
        <tr>
            <td>글 내용</td>
            <td><%=boardVO.getContent()%></td>
        </tr>
        <tr>
            <td>글 작성자</td>
            <td><%=boardVO.getWriter()%></td>
        </tr>
        <tr>
            <td colspan="2">
                <hr color="red">
                <a href="/board">
                    <img src="../resources/image/board.png" width="300" height="200">
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
