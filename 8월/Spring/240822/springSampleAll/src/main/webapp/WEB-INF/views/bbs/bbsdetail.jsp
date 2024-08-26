<%@ page import="mul.cam.e.dto.BbsDto" %>
<%@ page import="mul.cam.e.dto.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <style>
        .center{
            margin: auto;
            width: 1000px;
        }
        th{
            background-color: royalblue;
            color: white;
        }
    </style>

</head>
<body>

<h2>상세 글보기</h2>

<div class="center">

    <table class="table table-bordered">
        <col width="200"/><col width="500"/>

        <tr>
            <th>작성자</th>
            <td>${bbs.id}</td>
        </tr>
        <tr>
            <th>작성일</th>
            <td>${bbs.wdate}</td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${bbs.readcount}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${bbs.title}</td>
        </tr>
        <tr>
            <td colspan="2" style="height: 300px;font-size: 120%">
                <textarea rows="12" readonly style="background-color: #ffffff; font-size: 20px"
                          cols="15" class="form-control">${bbs.content}</textarea>
            </td>
        </tr>
    </table>


<%
    BbsDto bbs = (BbsDto)request.getAttribute("bbs");
    MemberDto login = (MemberDto)session.getAttribute("login");
%>

    <button type="button" class="btn btn-primary" onclick="answerBbs(<%=bbs.getSeq() %>)">답글</button>

<%
    if(login.getId().equals(bbs.getId())){
        %>
        <button type="button" class="btn btn-primary" onclick="updateBbs(<%=bbs.getSeq() %>)">글수정</button>

        <button type="button" class="btn btn-primary" onclick="deleteBbs(<%=bbs.getSeq() %>)">글삭제</button>
        <%
    }
%>
</div>

<script>
    function updateBbs(seq){
        location.href = "bbsupdate.do?seq=" + seq;
    }

    function answerBbs(seq) {
        location.href = "bbsanswer.do?seq=" + seq;
    }
</script>

<br/>

<%-- 답글 --%>
<div id="app" class="container">

    <form action="commentWrite.do" method="post">
        <input type="hidden" name="seq" value="${bbs.seq}"/>
        <input type="hidden" name="id" value="${login.id}">

        <table>
            <col width="1500px"/><col width="150px"/>
            <tr>
                <td>댓글</td>
                <td style="padding-left: 30px">올리기</td>
            </tr>
            <tr>
                <td>
                    <textarea rows="3" class="form-control" name="content"></textarea>
                </td>
                <td style="padding-left: 30px">
                    <button type="submit" class="btn btn-primary btn-block p-4">완료</button>
                </td>
            </tr>
        </table>
    </form>

    <br/><br/>

    <table class="table table-sm">
        <col width="500"/><col width="500"/>

        <tbody id="tbody">
        </tbody>
    </table>

</div>

<script>
$(document).ready(function () {

    $.ajax({
        url:"commentList.do",
        type:"get",
        data:{ seq:${bbs.seq} },
        success:function (json) {
            //alert('success');
            //alert(JSON.stringify(json));
            //alert(json[0].content);

            $("#tbody").html("");
            // document.getElementById("tbody").value = "";

            $.each(json, function (i, item) {
                let str = "<tr class='table-info'>"
                    +           "<td>작성자:" + item.id + "</td>"
                    +           "<td>작성일:" + item.wdate + "</td>"
                    +     "</tr>"
                    +     "<tr>"
                    +           "<td colspan='2'>" + item.content + "</td>"
                    +     "</tr>"
                    +     "<tr>"
                    +           "<td colspan='2'>&nbsp;</td>"
                    +     "</tr>";

                $("#tbody").append( str );
            });

        },
        error:function () {
            alert('error');
        }
    });

});

</script>



</body>
</html>
