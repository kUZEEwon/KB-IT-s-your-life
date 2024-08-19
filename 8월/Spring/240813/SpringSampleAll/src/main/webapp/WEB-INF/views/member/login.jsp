<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script> <!-- jQuery Cookie 플러그인 추가 -->
    <link rel="stylesheet" href="../resources/css/styles.css">
</head>
<body>
<div class="login-container">
    <h2>로그인</h2>
    <form action="loginAf.do" method="post">
        <table>
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" id="id" name="id" size="20"/>
                    <input type="checkbox" id="chk_saveid">아이디 저장
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td>
                    <input type="password" name="pw" size="20"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" value="로그인"/>
                    <div style="margin-top: 10px;">
                        <a href="regi.do">회원가입</a>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>

<script>
    $(document).ready(function() {
        let user_id = $.cookie("user_id");
        if (user_id != null) {
            // cookie가 있을 때
            $("#id").val(user_id);
            $("#chk_saveid").prop("checked", true);
        }

        $("#chk_saveid").click(function() {
            if ($("#chk_saveid").is(":checked")) {
                if ($("#id").val().trim() === "") {
                    alert("아이디를 입력하세요");
                    $("#chk_saveid").prop("checked", false);
                } else {
                    $.cookie("user_id", $("#id").val().trim(), { expires: 7 }); // 7일 동안 유효한 쿠키 설정
                }
            } else { // checkbox가 false
                $.removeCookie("user_id"); // 쿠키 삭제
            }
        });
    });
</script>
</body>
</html>
