<%--
  Created by IntelliJ IDEA.
  User: koo
  Date: 24. 7. 25.
  Time: 오후 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Game Form</title>
    <script>
        function btnClick (){
            //서블릿 호출 주소 : game
            let gameName = document .getElementById("gameName").value;
            let gameType = document .getElementById("gameType").value;
            location.href = "game?gameName=" + gameName + "&gameType=" +gameType;
        }
    </script>
</head>
<body>
    <h1>Game Form</h1>

    <h2>자바 스크립트로 get요청</h2>


        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td >gameName : </td>
                <td><input type="text" id="gameName" name="gameName"/></td>
            </tr>
            <tr>
                <td>gameType : </td>
                <td><input type="text" id="gameType" name="gameType"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button onclick="btnClick()">자바 스크립트로 GET요청</button>
                </td>
            </tr>
        </table>
    <hr color="blue"/>

    <%--PlayerServlet 호출 폼 (post요청)--%>
    <form action="player" method="post">
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td >playerName : </td>
                <td><input type="text" name="playerName"/></td>
            </tr>
            <tr>
                <td>playerType : </td>
                <td><input type="text" name="playerType"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="폼으로 POST요청"/>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
