<%--
  Created by IntelliJ IDEA.
  User: koo
  Date: 24. 7. 25.
  Time: 오후 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>로그인</title>
</head>
<body>

    <h1>로그인</h1>
    <img src="image/image.jpg" width="300" height="400"/>
    <hr>
    <form action="loginProcess" method="get">
        <!-- <form action="loginProcess" method="post"> -->
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td bgcolor="orange">아이디</td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td bgcolor="orange">비밀번호</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="로그인"/>
                </td>
            </tr>
        </table>
    </form>
    <br>
    <a href="insertUser.html">회원 가입</a> <br/>
    <hr>

</body>
</html>
