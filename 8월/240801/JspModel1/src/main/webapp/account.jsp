<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        .center{
            margin: auto;
            width: 60%;
            border: 3px solid #0000ff;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <h1>회원가입</h1>

    <div class="center">

        <form action="accountAf.jsp" method="post">
        <table border="1">
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" id="id" name="id" size="20"/>
                    <p id="idcheck"></p>
                    <button type="button" id="idcheckBtn">아이디첵크</button>
                </td>
            </tr>
            <tr>
                <th>패스워드</th>
                <td><input type="text" name="pw" size="20"></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="name" size="20"></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="text" name="email" size="20"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="회원가입">
                </td>
            </tr>
        </table>
        </form>
    </div>

<script>
$(function () {

    $("#idcheckBtn").click(function () {
        // alert('idcheckBtn click');
        // back-end
        $.ajax({
           url:"./idcheck.jsp",
           type:"post",
           data:{ "id":$("#id").val() },
           success:function (msg) {
               // alert('success');
               // alert(msg.trim());
               if(msg.trim() == "YES"){
                    $("#idcheck").css("color", "#0000ff");
                    $("#idcheck").html("사용할 수 있는 아이디입니다");
               }else{
                   $("#idcheck").css("color", "#ff0000");
                   $("#idcheck").html("사용중인 아이디입니다");
                   $("#id").val("");
               }
           },
           error:function () {
               alert('error');
           }
        });
    });
});
</script>

</body>
</html>
