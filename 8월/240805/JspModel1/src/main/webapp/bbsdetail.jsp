<%@ page import="dao.BbsDao" %>
<%@ page import="dto.BbsDto" %>
<%@ page import="dto.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int seq = Integer.parseInt( request.getParameter("seq") );

    // 조회수 증가

    BbsDao dao = BbsDao.getInstance();
    BbsDto bbs = dao.getBbs(seq);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div align="center">
    <h2>글 상세보기</h2>

    <table border="1">
        <colgroup>
            <col width="200px">
            <col width="400px">
        </colgroup>

        <tr>
            <th>작성자</th>
            <td><%=bbs.getId() %></td>
        </tr>
        <tr>
            <th>작성일</th>
            <td><%=bbs.getWdate()%></td>
        </tr>
        <tr>
            <th>조회수</th>
            <td><%=bbs.getReadcount() %></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><%=bbs.getTitle() %></td>
        </tr>
        <tr>
            <th>내용</th>
            <td>
                <textarea rows="15" cols="90" readonly><%=bbs.getContent() %></textarea>
            </td>
        </tr>
    </table>

    <br/>

    <%
        MemberDto member = (MemberDto)session.getAttribute("login");

        if(member.getId().equals(bbs.getId())) {
        %>
            <button type="button" onclick="updateBbs(<%=bbs.getSeq() %>)">수정</button>
        <%
        }
    %>

</div>

<script>
function updateBbs( seq ){
    location.href = "bbsupdate.jsp?seq=" + seq;
}

</script>


</body>
</html>
