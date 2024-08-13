<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="../resources/css/styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<div class="signup-container">
    <h2>회원가입</h2>
    <form action="regiAf.do" method="post">
        <table>
            <tr>
                <td>아이디</td>
                <td>
                    <input type="text" id="id" name="id" />
                    <p id="idcheck"  class="info-text"></p>
                    <input type="button" id="btn" value="아이디 확인" />
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                    <input type="password" name="pw" />
                </td>
            </tr>
            <tr>
                <td>이름</td>
                <td>
                    <input type="text" name="name" />
                </td>
            </tr>
            <tr>
                <td>이메일</td>
                <td>
                    <input type="email" name="email" />
                </td>
            </tr>
            <tr>
                <td colspan="2" class="submit-row">
                    <input type="submit" value="회원 가입" />
                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    $(document).ready(function (){
        $("#btn").click( function (){

            // id체크 (글자수, 대소문자)
            if($("#id").val() === ""){
                alert('아이디를 입력해주세요.');
                return;
            }

            $.ajax({
                url:"checkId.do",
                type:"get",
                data: { id: $("#id").val()},
                success:function (msg){
                    if(msg === "YES"){
                        $("#idcheck").css("color", "blue");
                        $("#idcheck").html("사용 가능한 아이디 입니다.");
                    }
                    else{
                        $("#idcheck").css("color", "#ff0000");
                        $("#idcheck").html("사용 중인 아이디 입니다.");
                        $("#id").val("");
                    }

                },
                error:function (){
                    $("#idcheck").text("서버 오류가 발생했습니다.");
                }
            })
        });
    })
</script>
</body>
</html>
