<%@ page import="com.multi.spring2.board.domain.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board List</title>
    <link rel="stylesheet" href="../resources/css/out.css">
</head>
<body>
<%
    // List of BoardVO objects retrieved from the request attribute
    List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("all");
%>

<div class="container">
    <h1>Board List</h1>
    <table>
        <thead>
        <tr>
            <th>NO</th>
            <th>TITLE</th>
            <th>CONTENT</th>
            <th>WRITER</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (boardList != null && !boardList.isEmpty()) {
                // Iterate over the list of BoardVO objects and display each
                for (BoardVO vo : boardList) {
        %>
        <tr>
            <td><%= vo.getNo() %></td>
            <td><%= vo.getTitle() %></td>
            <td><%= vo.getContent() %></td>
            <td><%= vo.getWriter() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4">No board found</td>
        </tr>
        <%
            }
        %>
        <tr>
            <td colspan="4">
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
