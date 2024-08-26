<%@ page import="mul.cam.e.util.BbsUtil" %>
<%@ page import="mul.cam.e.dto.BbsDto" %>
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
    <div class="card mb-4">
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
            <%-- 답글 버튼 --%>
            <a href="bbsanswer.do?seq=${bbsdetail.seq}" class="btn btn-success">답글</a>
            <!-- 수정 버튼 -->
            <a href="bbsupdate.do?seq=${bbsdetail.seq}" class="btn btn-warning">수정</a>
            <!-- 삭제 버튼 -->
            <a href="bbsdelete.do?seq=${bbsdetail.seq}" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
        </div>
    </div>

    <%-- 댓글 입력창 + 올리기 버튼 --%>

    <div class="card mb-4">
        <form action="/bbs/bbscomment.do" method="post" class="card-body">
            <!-- Hidden Inputs -->
            <input type="hidden" name="bbsSeq" value="${bbsdetail.seq}">
            <input type="hidden" name="id" value="${login.id}">
            <div class="mb-3">
                <!-- 댓글 입력창 -->
                <textarea name="comment" class="form-control" rows="3" placeholder="댓글을 입력해 주세요..."></textarea>
            </div>
            <div class="text-end">
                <!-- 올리기 버튼 -->
                <button type="submit" class="btn btn-primary">올리기</button>
            </div>
        </form>
    </div>

    <%-- 댓글 전부 보이게 하기 --%>
    <%--할일
    수정, 삭제 버튼 만들기
    수정 버튼 누르면 댓글 입력창(input tag)로 변해야 한다.
    --%>
    <div class="card">
        <div class="card-header">
            <h5 class="card-title mb-0">댓글 목록</h5>
        </div>
        <div class="card-body p-0">
            <table class="table table-hover mb-0">
                <thead>
                <tr>
                    <th>작성자(id)</th>
                    <th>댓글</th>
                    <th>댓글 작성 시간</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="comment" items="${commentDto}">
                    <tr id="comment-row-${comment.seq}">
                        <td>${comment.id}</td>
                        <td>
                            <span id="comment-text-${comment.seq}">${comment.comment}</span>
                            <input type="text" id="comment-input-${comment.seq}" value="${comment.comment}" style="display:none;">
                        </td>
                        <td>${comment.wdate}</td>
                        <td>
                            <button type="button" class="btn btn-sm btn-primary btn-edit" data-seq="${comment.seq}" data-bbsseq="${comment.bbsSeq}">수정</button>
                            <button type="button" class="btn btn-sm btn-success" style="display:none;" id="save-btn-${comment.seq}" data-seq="${comment.seq}" data-bbsseq="${comment.bbsSeq}">저장</button>
                        </td>
                        <td>
                            <form action="/bbs/bbscommentDelete.do" method="get" style="display:inline;">
                                <input type="hidden" name="seq" value="${comment.seq}">
                                <input type="hidden" name="bbsSeq" value="${comment.bbsSeq}">
                                <button type="submit" class="btn btn-sm btn-danger">삭제</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/js-cookie/3.0.1/js.cookie.min.js"></script>
    <script>
        $(document).ready(function () {
            // 동기식으로 불러오기 위해서 사용함
            // 문서를 전부 다 읽어들인 후에 작동!

            // 댓글 수정 버튼 클릭 시 호출될 함수
            function saveComment(commentSeq, bbsSeq) {
                // 댓글 내용 가져오기
                const commentInput = $('#comment-input-' + commentSeq).val();

                // AJAX 요청 보내기
                $.ajax({
                    url: '/bbs/bbscommentUpdate.do',
                    type: 'POST',
                    contentType: 'application/json', // JSON 형식으로 전송
                    data: JSON.stringify({
                        seq: commentSeq,
                        comment: commentInput,
                        bbsSeq: bbsSeq
                    }),
                    success: function (response) {
                        // 댓글 수정 성공 후 페이지를 리다이렉트
                        window.location.href = '/bbs/bbsdetail.do?seq=' + bbsSeq;
                    },
                    error: function (xhr, status, error) {
                        // 오류 발생 시 콘솔에 오류 출력
                        console.error('댓글 수정 중 오류 발생:', status, error);
                    }
                });
            }

            // 수정 버튼 클릭 시 이벤트 핸들러 설정
            $('.btn-edit').on('click', function () {
                const commentSeq = $(this).data('seq');
                const bbsSeq = $(this).data('bbsseq');

                // 수정 버튼 클릭 시 호출되는 함수
                editComment(commentSeq);
            });

            // 저장 버튼 클릭 시 이벤트 핸들러 설정
            $(document).on('click', '.btn-success', function () {
                const commentSeq = $(this).data('seq');
                const bbsSeq = $(this).data('bbsseq');
                saveComment(commentSeq, bbsSeq);
            });
        });

        // 댓글 수정 입력 필드와 저장 버튼 표시 함수
        function editComment(commentSeq) {
            $('#comment-text-' + commentSeq).hide();
            $('#comment-input-' + commentSeq).show();
            $('#save-btn-' + commentSeq).show();
            $('.btn-edit').hide();
        }

    </script>
<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
