<%@ page import="java.util.List" %>
<%@ page import="mul.cam.e.dto.BbsDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    List<BbsDto> bbslist = (List<BbsDto>)request.getAttribute("bbslist");
%>
<head>
    <title>게시물 목록</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .center {
            margin: auto;
            width: 1000px;
            text-align: center;
        }
        th {
            background-color: royalblue;
            color: white;
        }
        tr{
            line-height: 12px;
        }
    </style>
</head>
<body>
    <h2>게시판</h2>
    <br/>

    <div class="center">
        <table class="table table-hover">
            <col width="70"/><col width="600"/><col width="100"/><col width="150"/>
            <thead>
                <tr>
                    <th>번호</th> <th>제목</th> <th>조회수</th> <th>작성자</th>
                </tr>
            </thead>

            <tbody>
                <%
                    if (bbslist == null || bbslist.size() == 0) {
                %>
                    <tr>
                        <td colspan="4">작성된 글이 없어요.</td>
                    </tr>
                <%
                    } else {
                        for(int i=0;i<bbslist.size();i++) {
                            BbsDto bbs = bbslist.get(i);
                %>
                    <tr>
                        <td><%=i+1%></td>
                        <td><%=bbs.getTitle()%></td>
                        <td><%=bbs.getReadcount()%></td>
                        <td><%=bbs.getId()%></td>
                    </tr>
                <%
                        }
                    }
                %>


            </tbody>
        </table>

        <br/>

        <a href="bbswrite.do">글쓰기</a>
    </div>
</body>
</html>
