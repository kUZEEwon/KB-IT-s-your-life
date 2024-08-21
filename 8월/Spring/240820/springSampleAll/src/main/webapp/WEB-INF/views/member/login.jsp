<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/js-cookie@3.0.1/dist/js.cookie.min.js"></script>
    <style>
        .center {
            max-width: 400px;
            margin: auto;
            border: 1px solid #007bff;
            padding: 20px;
            border-radius: 8px;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="center">
        <h2 class="text-center mb-4">Login</h2>
        <form action="loginAf.do" method="post">
            <div class="mb-3">
                <label for="id" class="form-label">아이디</label>
                <input type="text" id="id" name="id" class="form-control" placeholder="아이디">
            </div>
            <div class="mb-3">
                <label for="pw" class="form-label">패스워드</label>
                <input type="password" id="pw" name="pw" class="form-control" placeholder="패스워드">
            </div>
            <div class="mb-3 form-check">
                <input type="checkbox" id="chk_saveid" class="form-check-input">
                <label for="chk_saveid" class="form-check-label">아이디 저장</label>
            </div>
            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-primary">로그인</button>
                <a href="regi.do" class="btn btn-link">회원가입</a>
            </div>
        </form>
    </div>
</div>

<script>
    $(document).ready(function () {
        let userId = Cookies.get('user_id');
        if (userId) {
            $('#id').val(userId);
            $('#chk_saveid').prop('checked', true);
        }

        $('#chk_saveid').on('change', function () {
            if ($(this).is(':checked')) {
                let userIdValue = $('#id').val().trim();
                if (userIdValue === '') {
                    alert('아이디를 입력해 주십시오');
                    $(this).prop('checked', false);
                } else {
                    Cookies.set('user_id', userIdValue);
                }
            } else {
                Cookies.remove('user_id');
            }
        });
    });
</script>
</body>
</html>
