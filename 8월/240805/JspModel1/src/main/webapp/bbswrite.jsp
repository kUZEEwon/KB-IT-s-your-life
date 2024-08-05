<%@ page import="dto.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MemberDto member = (MemberDto) session.getAttribute("login");
    // member = null -> login
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div align="center">
    <h2>글쓰기</h2>

    <form action="bbswriteAf.jsp" method="post">
        <table border="1">
        <col width="200"/><col width="400"/>
            <tr>
                <td>아이디</td>
                <td>
                    <%=member.getId() %>
                    <input type="hidden" name="id" value="<%=member.getId() %>">
                </td>
            </tr>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" name="title" size="50px">
                </td>
            </tr>
            <tr>
                <td>내용</td>
                <td>
                    <textarea rows="20" cols="50px" name="content" placeholder="내용을 기입"></textarea>
                </td>
            </tr>
        </table>

        <br/>
        <input type="submit" value="작성완료">
    </form>
</div>

</body>
</html>
