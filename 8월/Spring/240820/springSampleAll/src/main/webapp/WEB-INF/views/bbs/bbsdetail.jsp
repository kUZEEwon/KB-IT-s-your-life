<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BBS Detail</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container my-5">
    <div class="card">
        <div class="card-header text-center">
            <h2 class="card-title"><c:out value="${bbsdetail.title}"/></h2>
        </div>
        <div class="card-body">
            <div class="row mb-3">
                <label class="col-sm-2 col-form-label">작성자:</label>
                <div class="col-sm-10">
                    <p class="form-control-plaintext"><c:out value="${bbsdetail.id}"/></p>
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2 col-form-label">작성일:</label>
                <div class="col-sm-10">
                    <p class="form-control-plaintext"><c:out value="${bbsdetail.wdate}"/></p>
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2 col-form-label">조회수:</label>
                <div class="col-sm-10">
                    <p class="form-control-plaintext"><c:out value="${bbsdetail.readcount}"/></p>
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2 col-form-label">내용:</label>
                <div class="col-sm-10">
                    <div class="border rounded p-3 bg-light">
                        <c:out value="${bbsdetail.content}" escapeXml="false"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="card-footer text-center">
            <a href="bbslist.do" class="btn btn-primary">목록으로 돌아가기</a>
            <!-- 수정 버튼 -->
            <a href="bbsupdate.do?seq=${bbsdetail.seq}" class="btn btn-warning">수정</a>
            <!-- 삭제 버튼 -->
            <a href="bbsdelete.do?seq=${bbsdetail.seq}" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
        </div>
    </div>
</div>

<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
