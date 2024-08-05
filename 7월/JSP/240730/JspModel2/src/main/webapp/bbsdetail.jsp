<%@ page import="dao.BbsDao" %>
<%@ page import="dto.BbsDto" %>
<%@ page import="dto.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int seq = Integer.parseInt(request.getParameter("seq"));

    BbsDao dao = BbsDao.getInstance();

    // 조회수 증가
    dao.increReadCount(seq);

    BbsDto bbs = dao.getBbs(seq);
%>

<html>
<head>
    <title>글 상세보기</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        textarea {
            width: 100%;
            box-sizing: border-box;
        }
        button {
            padding: 10px;
            font-size: 16px;
        }
    </style>
</head>
<body>

<div align="center">
    <h2>글 상세보기</h2>

    <table>
        <colgroup>
            <col width="200px">
            <col width="400px">
        </colgroup>
        <tr>
            <th>순번</th>
            <td><%=bbs.getSeq() %></td>
        </tr>

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
                <textarea rows="15" readonly><%=bbs.getContent() %></textarea>
            </td>
        </tr>
    </table>

    <br/>

    <%
        MemberDto member = (MemberDto)session.getAttribute("login");

        if (member != null && member.getId().equals(bbs.getId())) {
    %>
    <button type="button" onclick="updateBbs(<%=bbs.getSeq() %>)">수정</button>
    <%
        }
    %>

</div>

<script>
    function updateBbs(seq) {
        location.href = "Bbs?param=bbsupdate&seq=" + seq;
    }
</script>

</body>
</html>
