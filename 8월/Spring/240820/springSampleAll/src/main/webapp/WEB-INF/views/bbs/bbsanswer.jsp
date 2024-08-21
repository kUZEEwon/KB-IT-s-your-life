<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BBS Answer</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="text-center mb-4">
        <h2>기본글</h2>
    </div>

    <div class="card">
        <div class="card-body">
            <table class="table table-bordered">
                <colgroup>
                    <col width="200"/>
                    <col width="500"/>
                </colgroup>

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
                    <td colspan="2">${bbs.content}</td>
                </tr>
            </table>
        </div>
    </div>

    <div class="mt-4">
        <form action="bbsanswerAf.do" method="post">
            <input type="hidden" name="seq" value="${bbs.seq}"/>

            <div class="card">
                <div class="card-body">
                    <table class="table table-bordered">
                        <tr>
                            <th>아이디</th>
                            <td>
                                <input type="text" class="form-control" size="50" name="id" value="${login.id}" readonly/>
                            </td>
                        </tr>

                        <tr>
                            <th>제목</th>
                            <td>
                                <input type="text" class="form-control" size="50" name="title"/>
                            </td>
                        </tr>

                        <tr>
                            <th>내용</th>
                            <td>
                                <textarea class="form-control" rows="10" name="content" placeholder="내용을 입력하세요"></textarea>
                            </td>
                        </tr>
                    </table>

                    <button type="submit" class="btn btn-primary">답글 작성 완료</button>
                </div>
            </div>
        </form>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
