<%@ page import="mul.cam.e.dto.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%--
    MemberDto mem = (MemberDto) session.getAttribute("login");
--%>

    <h2>글쓰기</h2>

    <div align="center">

    <form action="bbswriteAf.do" method="post">

        <table class="table table-bordered" style="width: 1000px">
        <tr>
            <th>아이디</th>
            <td>
                <input type="text" name="id" size="70px" value="${login.id}" class="form-control" readonly/>
            </td>
        </tr>
        <tr>
            <th>제목</th>
            <td>
                <input type="text" name="title" size="70px" class="form-control"/>
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td>
                <textarea rows="20" cols="80" name="content" class="form-control" placeholder="내용을 작성"></textarea>
            </td>
        </tr>
        </table>

        <input type="submit" value="글쓰기">
    </form>

    </div>

</body>
</html>
