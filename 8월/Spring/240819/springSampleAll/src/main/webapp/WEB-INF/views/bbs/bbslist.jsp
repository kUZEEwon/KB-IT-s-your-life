<%@ page import="java.util.List" %>
<%@ page import="mul.cam.e.dto.BbsDto" %>
<%@ page import="mul.cam.e.dto.BbsPram" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<BbsDto> bbslist = (List<BbsDto>)request.getAttribute("bbslist");
    int pageBbs = (Integer) request.getAttribute("pageBbs"); // 총 페이지 수

    BbsPram param = (BbsPram)request.getAttribute("param");
    int pageNumber = param.getPageNumber(); // 현재 페이지 수
%>

<html>
<head>
    <title>bbslist</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.twbsPagination.min.js"></script>

    <style>
        .center{
            margin: auto;
            width: 1000px;
            text-align: center;
        }
        th{
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
                <th>번호</th><th>제목</th><th>조회수</th><th>작성자</th>
            </tr>
            </thead>

            <tbody>
            <%
                if(bbslist == null || bbslist.size() == 0) {
                %>
                <tr>
                    <td colspan="4">작성된 글이 없습니다</td>
                </tr>
                <%
                }else{

                    for(int i = 0; i < bbslist.size(); i++) {
                        BbsDto bbs = bbslist.get(i);
                        %>
                        <tr>
                            <td><%=i + 1 %></td>
                            <td><%=bbs.getTitle() %></td>
                            <td><%=bbs.getReadcount()%></td>
                            <td><%=bbs.getId()%></td>
                        </tr>
                        <%
                    }
                }
            %>

            </tbody>
        </table>

        <%--paging--%>
        <div class="container">
            <nav aria-label="Page navigation">
                <ul class="pagination" id="pagination"  style="justify-content:center"></ul>
            </nav>
        </div>

        <br/>

        <%--search--%>
        <div class="form-row align-items-center d-flex justify-content-center align-items-center container">
            <select id="category" class="form-control" style="width:auto;">
                <option value="start">검색</option>
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="writer">작성자</option>
            </select>&nbsp;

            <div class="col-sm-3 my-1" style="width:auto;">
                <input type="text" id="keyword" class="form-control" value="">
            </div>&nbsp;

            <button type="button" onclick="searchBtn()" class="btn btn-primary">검색</button>

        </div>
        <br/>
        <a href="bbswrite.do">글 쓰기</a>
    </div>
    <script>
        function searchBtn(){
            let category = document.getElementById("category").value;
            let keyword = document.getElementById("keyword").value;

            location.href="bbslist.do?category=" + category+"&keyword="+keyword;

        }

      /*  let totalCount = 26; // 26 개의 글
        let pageNumber = 1; // 현재 페이지

        let pageBbs = totalCount/10;
        if((totalCount % 10)>0 ){
            pageBbs = pageBbs + 1;
        }*/

        $("#pagination").twbsPagination({
            startPage:<%=pageNumber + 1%>,
            totalPages:<%=pageBbs%>, // 글의 총 수
            visiblePages:10,
            first:'<span srid-hidden="true">«</span>',		// 처음 페이지로 이동
            prev:"이전",
            next:"다음",
            last:'<span srid-hidden="true">»</span>',
            initiateStartPageClick:false, // 자동 실행이 되지 않도록 설정
            onPageClick:function (event, page){
                // 현재 페이지 번호를 서버에 전달하여 페이지 전환
                location.href = "bbslist.do?pageNumber=" + page;
            }
        });

    </script>
</body>
</html>
