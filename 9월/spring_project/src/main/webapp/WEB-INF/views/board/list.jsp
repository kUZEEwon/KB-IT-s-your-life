<%@ page import="org.scoula.board.domain.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<%@include file="../layouts/header.jsp"%>
<%
    List<BoardVO> boards = (List<BoardVO>) request.getAttribute("list");
    int size = boards.size();
%>


<h1 class="page-header my-4"><i class="fas fa-list"></i> 글 목록</h1>

<table class="table table-hover">
    <thead>
    <tr>
        <th style="width: 60px">No</th>
        <th>제목</th>
        <th style="width: 100px">작성자</th>
        <th style="width: 250px">등록일</th>
    </tr>
    </thead>
    <tbody>
    <!--


    문제 2번: JSP코드 구현 부분

    조건1- jstl을 이용하여 반복문 처리해야함.

    조건2- 게시판 제목을 클릭했을 때 해당 번호에 맞는 상세페이지를 호출하도록 a태그로 링크 처리해야함.

    -->
    <%
        for(int i=0; i <size; i++){
            BoardVO board = boards.get(i);
            %>
            <tr>
                <th><%=size-i%></th>
                <th><a href="/board/get?no=<%=board.getNo()%>"><%=board.getTitle()%></a></th>
                <th><%=board.getWriter()%></th>
                <th><%=board.getRegDate()%></th>
            </tr>


            <%
        }
    %>

    </tbody>

</table>

<div class="text-right">
    <a href="create" class="btn btn-primary">
        <i class="far fa-edit"></i>
        글쓰기
    </a>
</div>

<%@include file="../layouts/footer.jsp"%>
