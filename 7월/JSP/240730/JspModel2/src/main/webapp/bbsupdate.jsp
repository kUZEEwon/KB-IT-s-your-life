<%@ page import="dao.BbsDao" %>
<%@ page import="dto.BbsDto" %>
<%@ page import="dto.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int seq = Integer.parseInt(request.getParameter("seq"));

    BbsDao dao = BbsDao.getInstance();
    BbsDto bbs = dao.getBbs(seq);

    if (bbs == null) {
        response.sendRedirect("bbslist.jsp"); // 게시글이 없는 경우 목록 페이지로 리디렉션
        return;
    }

    MemberDto member = (MemberDto)session.getAttribute("login");
    if (member == null || !member.getId().equals(bbs.getId())) {
        response.sendRedirect("bbslist.jsp"); // 권한이 없는 경우 목록 페이지로 리디렉션
        return;
    }
%>

<html>
<head>
    <title>게시글 수정</title>
</head>
<body>

<div align="center">
    <h2>게시글 수정</h2>

    <form action="Bbs?param=bbsupdateAf" method="post">
        <input type="hidden" name="seq" value="<%= bbs.getSeq() %>">
        <table border="1">
            <colgroup>
                <col width="200px">
                <col width="400px">
            </colgroup>
            <tr>
                <th>작성자</th>
                <td><%= bbs.getId() %></td>
            </tr>
            <tr>
                <th>작성일</th>
                <td><%= bbs.getWdate() %></td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name="title" size="50" value="<%= bbs.getTitle() %>">
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea name="content" rows="15" cols="50"><%= bbs.getContent() %></textarea>
                </td>
            </tr>
        </table>
        <br/>
        <input type="submit" value="수정 완료">
    </form>

    <br/>
    <button onclick="location.href='bbslist.jsp'">목록으로</button>
</div>

</body>
</html>
