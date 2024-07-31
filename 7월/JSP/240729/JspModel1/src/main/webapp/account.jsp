<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 500px;
            padding: 20px;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 10px 0;
            cursor: pointer;
            border-radius: 4px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>회원가입</h1>
    <form action="accountAf.jsp" method="post">
        <div class="form-group">
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" required/>
            <p id = "idcheck"></p>
            <button id="idcheckBtn">아이디 확인</button>
        </div>
        <div class="form-group">
            <label for="pw">비밀번호</label>
            <input type="password" id="pw" name="pw" required>
        </div>
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" required>
        </div>
        <input type="submit" value="회원가입">
    </form>
</div>

<script>
    $(
        function () {
            // 함수를 만들고 호출해라
            $("#idcheckBtn").click(function () {
                // alert('idcheckBtn click');
                // back-end
                $.ajax({
                    url:"./idcheck.jsp",
                    type: "post",
                    data: { "id" : $("#id").val()},
                    success:function (msg){
                       //alert(msg.trim());
                        if(msg.trim() == "YES"){
                            $("#idcheck").css("color", "#0000ff");
                            $("#idcheck").html("사용할 수 있는 아이디 입니다.");
                        }else {
                            $("#idcheck").css("color", "#ff0000");
                            $("#idcheck").html("사용 중인 아이디 입니다.");
                            $("#id").val("");
                        }

                    },
                    error: function (){
                        alert("error");
                    }
                });

            })
        }
    );
</script>

</body>
</html>
