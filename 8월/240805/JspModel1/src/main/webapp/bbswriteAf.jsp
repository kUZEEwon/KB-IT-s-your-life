    <%@ page import="dto.BbsDto" %>
<%@ page import="dao.BbsDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");

    String id = request.getParameter("id");
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    BbsDto bbs = new BbsDto(id, title, content);

    BbsDao dao = BbsDao.getInstance();
    boolean isS = dao.bbswrite(bbs);
    if (isS) {
        %>
        <script>
            alert("글 작성 성공!");
            location.href = "bbslist.jsp";
        </script>
        <%
    }else{
        %>
        <script>
            alert("다시 작성해 주십시오");
            location.href = "bbswrite.jsp";
        </script>
        <%
    }
    %>

</body>
</html>
