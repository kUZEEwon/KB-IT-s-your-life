<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
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
</body>
</html>
