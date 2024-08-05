<%@ page import="dao.BbsDao" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.BbsDto" %>
<%@ page import="util.BbsUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>게시판</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th, td {
            vertical-align: top;
        }
        select, input[type="text"], button {
            margin: 5px;
        }
    </style>
</head>
<body>

<div align="center">
    <h2>게시판</h2>

    <table>
        <col width="70">
        <col width="600">
        <col width="100">
        <col width="150">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>조회수</th>
            <th>작성자</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<BbsDto> list = (List<BbsDto>) request.getAttribute("list");
            if (list == null || list.size() == 0) {
        %>
        <tr>
            <td colspan="4">작성된 글이 없습니다</td>
        </tr>
        <%
        } else {
            for (int i = 0; i < list.size(); i++) {
                BbsDto dto = list.get(i);
        %>
        <tr>
            <td><%= i + 1 %></td>
            <td>
                <a href="bbsdetail.jsp?seq=<%= dto.getSeq() %>"><%= BbsUtil.dot3(dto.getTitle()) %></a>
            </td>
            <td><%= dto.getReadcount() %></td>
            <td><%= dto.getId() %></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
    <br/><br/>

    <form id="searchForm">
        <select id="category" name="category">
            <option value="title">제목</option>
            <option value="content">내용</option>
            <option value="writer">작성자</option>
        </select>

        <input type="text" id="keyword" name="keyword" size="20"/>

        <button type="button" onclick="search()">검색</button>
    </form>

    <br/><br/>
    <a href="bbswrite.jsp">글쓰기</a>

</div>

<script>
    function search() {
        let category = document.getElementById("category").value;
        let keyword = document.getElementById("keyword").value;

        // 검색어가 없는 경우 경고
        if (keyword.trim() === "") {
            alert("검색어를 입력해 주세요.");
            return;
        }

        // URL 인코딩 처리
        let encodedKeyword = encodeURIComponent(keyword);

        // 올바른 URL 구성
        location.href = "Bbs?param=bbslist&category=" + category + "&keyword=" + encodedKeyword;
    }
</script>


</body>
</html>
