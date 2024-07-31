
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <style type="text/css">
        .center{
            margin: auto;
            width: 60%;
            border: 3px;
        }
    </style>
</head>
<body>
    <h3>login</h3>
    <div class="center">
        <form action="Member" method="post">
            <input type="hidden" name="param" value="loginAf"/>
            <table border="1">
                <tr>
                    <th>아이디</th>
                    <td>
                        <input type="text" name="id" size="20"/>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td>
                        <input type="password" name="pw" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="로그인">
                        <a href="Member?param=account">회원 가입</a>
                    </td>

                </tr>
            </table>
        </form></div>
</body>
</html>
