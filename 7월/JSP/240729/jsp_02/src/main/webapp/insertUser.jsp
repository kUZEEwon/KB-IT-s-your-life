<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
            display: flex;
            align-items: center;
        }
        .form-group label {
            width: 120px;
            text-align: right;
            padding-right: 10px;
            font-weight: bold;
        }
        .form-group input[type="text"],
        .form-group input[type="password"] {
            width: calc(100% - 140px);
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .form-group input[type="radio"] {
            margin-right: 5px;
        }
        .form-group .radio-group {
            display: flex;
            align-items: center;
        }
        .form-group .radio-group label {
            margin-left: 5px;
        }
        .form-group button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .form-group button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>회원가입</h1>
    <form action="insertUser.do" method="post">
        <div class="form-group">
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" value="spring" required>
        </div>
        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" value="1234" required>
        </div>
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" value="spring" required>
        </div>
        <div class="form-group">
            <label>권한</label>
            <div class="radio-group">
                <label for="role_user">USER</label>
                <input type="radio" id="role_user" name="role" value="USER" checked>
                <label for="role_admin">ADMIN</label>
                <input type="radio" id="role_admin" name="role" value="ADMIN">

            </div>
        </div>
        <div class="form-group">
            <button type="submit">서버로 전송</button>
        </div>
    </form>
</div>
</body>
</html>
