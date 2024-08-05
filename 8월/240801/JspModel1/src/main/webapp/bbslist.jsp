<%@ page import="dao.BbsDao" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.BbsDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
public String dot3(String title) {
    String str = "";

    if (title.length() > 35) {
        str = title.substring(0, 35);
        str += "...";
    }else{
        str = title.trim();
    }
    return str;
}
%>

<%
    String category = request.getParameter("category");
    String keyword = request.getParameter("keyword");
    if(category == null){
        category = "";
    }
    if(keyword == null){
        keyword = "";
    }

    BbsDao dao = BbsDao.getInstance();
    // List<BbsDto> list = dao.getBbslist();
    List<BbsDto> list = dao.getBbsSearchlist(category, keyword);
%>

<html>
<head>
    <title>게시판</title>
</head>
<body>

<div align="center">

    <h2>게시판</h2>

    <table border="1">
        <col width="70"><col width="600"><col width="100"><col width="150">

        <thead>
        <tr>
            <th>번호</th><th>제목</th><th>조회수</th><th>작성자</th>
        </tr>
        </thead>

        <tbody>
        <%
        if(list == null || list.size() == 0){
            %>
            <tr>
                <td colspan="4">작성된 글이 없습니다</td>
            </tr>
            <%
        }else{

            for (int i = 0; i < list.size(); i++) {
                BbsDto dto = list.get(i);
            %>
            <tr>
                <th><%=i + 1 %></th>
                <td>
                    <a href="bbsdetail.jsp?seq=<%=dto.getSeq() %>"><%= dot3(dto.getTitle()) %></a>
                </td>
                <td><%=dto.getReadcount() %></td>
                <td><%=dto.getId() %></td>
            </tr>
            <%
            }
        }
        %>
        </tbody>
    </table>
    <br/><br/>

    <select id="category">
        <option value="title">제목</option>
        <option value="content">내용</option>
        <option value="writer">작성자</option>
    </select>

    <input type="text" id="keyword" size="20"/>

    <button type="button" onclick="search()">검색</button>

    <br/><br/>
    <a href="bbswrite.jsp">글쓰기</a>

</div>

<script>
    function search() {

        let category = document.getElementById("category").value;
        let keyword = document.getElementById("keyword").value;

        // 검색어 검사

        location.href = "bbslist.jsp?category=" + category + "&keyword=" + keyword;
    }

</script>

</body>
</html>
