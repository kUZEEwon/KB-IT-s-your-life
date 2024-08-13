<%@ page import="com.multi.win00.domain.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member Info</title>
</head>
<body>
<h1>Member Information</h1>
<br/>
<%
    BoardVO board = (BoardVO) request.getAttribute("board");
%>

검색된 결과 no 는 <%=board.getNo()%><br/>
검색된 결과 title 는 <%=board.getTitle()%><br/>
검색된 결과 content 는 <%=board.getContent()%><br/>
검색된 결과 writer 는 <%=board.getWriter()%>
</body>
</html>
