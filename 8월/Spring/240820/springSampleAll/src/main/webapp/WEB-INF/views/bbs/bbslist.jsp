<%@ page import="java.util.List" %>
<%@ page import="mul.cam.e.dto.BbsDto" %>
<%@ page import="mul.cam.e.dto.BbsParam" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<BbsDto> bbslist = (List<BbsDto>)request.getAttribute("bbslist");
    int pageBbs = (Integer) request.getAttribute("pageBbs");    // 총 페이지수

    BbsParam param = (BbsParam)request.getAttribute("param");
    int pageNumber = param.getPageNumber();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.twbsPagination.min.js"></script>
    <style>
        .center {
            max-width: 1000px;
            margin: auto;
        }
        th {
            background-color: royalblue;
            color: white;
        }
        .pagination {
            justify-content: center;
        }
    </style>
</head>
<body>

<div class="container mt-4">
    <h2 class="text-center">게시판</h2>

    <div class="center mt-4">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>조회수</th>
                <th>작성자</th>
            </tr>
            </thead>
            <tbody>
            <% if (bbslist == null || bbslist.size() == 0) { %>
            <tr>
                <td colspan="4" class="text-center">작성된 글이 없습니다</td>
            </tr>
            <% } else {
                for (int i = 0; i < bbslist.size(); i++) {
                    BbsDto bbs = bbslist.get(i);
                    String title = bbs.getTitle();
                    int maxLength = 30; // 최대 길이 설정
                    if (title.length() > maxLength) {
                        title = title.substring(0, maxLength) + "...";
                    }
            %>
            <tr>
                <td><%= i + 1 %></td>
                <td>
                    <a href="bbsdetail.do?seq=<%= bbs.getSeq() %>">
                        <%= title %>
                    </a>
                </td>
                <td><%= bbs.getReadcount() %></td>
                <td><%= bbs.getId() %></td>
            </tr>
            <% } } %>
            </tbody>
        </table>

        <!-- Paging -->
        <div class="mt-4">
            <nav aria-label="Page navigation">
                <ul class="pagination" id="pagination"></ul>
            </nav>
        </div>

        <!-- Search -->
        <div class="form-row align-items-center d-flex justify-content-center mt-4">
            <select id="category" class="form-select me-2" style="width:auto;">
                <option value="start">검색</option>
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="writer">작성자</option>
            </select>

            <div class="col-sm-3 my-1">
                <input type="text" id="keyword" class="form-control" value="<%= param.getKeyword() %>">
            </div>

            <button type="button" onclick="searchBtn()" class="btn btn-primary ms-2">검색</button>
        </div>

        <!-- Write -->
        <div class="text-center mt-4">
            <a href="bbswrite.do" class="btn btn-success">글쓰기</a>
        </div>
    </div>
</div>

<script>
    let category = "<%= param.getCategory() %>";
    if (category) {
        document.getElementById("category").value = category;
    }

    function searchBtn() {
        let category = document.getElementById("category").value;
        let keyword = document.getElementById("keyword").value;
        location.href = "bbslist.do?category=" + category + "&keyword=" + keyword;
    }

    $("#pagination").twbsPagination({
        startPage: <%= pageNumber + 1 %>,
        totalPages: <%= pageBbs %>,
        visiblePages: 10,
        first: '<span aria-hidden="true">«</span>',
        prev: "이전",
        next: "다음",
        last: '<span aria-hidden="true">»</span>',
        initiateStartPageClick: false,
        onPageClick: function (event, page) {
            let category = document.getElementById("category").value;
            let keyword = document.getElementById("keyword").value;
            location.href = "bbslist.do?category=" + category + "&keyword=" + keyword + "&pageNumber=" + (page - 1);
        }
    });
</script>

</body>
</html>
