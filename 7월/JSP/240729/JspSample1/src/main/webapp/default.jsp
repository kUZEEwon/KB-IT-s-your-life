<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%-- jsp에서 jsp로 전송 model 1 --%>
<h3>jsp에서 jsp로 전송</h3>
<form action="index4.jsp" method="post">
    이름 : <input type="text" name="name"/><br/>
    나이 : <input type="text" name="age"/><br/>
    좋아하는 과일 :
    <select name="fruits">
        <option value="grape">포도</option>
        <option value="banana">바나나</option>
        <option value="apple">사과</option>
    </select>
    <br/>

    <input type="checkbox" name="hobby" value="painting" /> 그림<br/>
    <input type="checkbox" name="hobby" value="music"/> 음악듣기<br/>
    <input type="checkbox" name="hobby" value="game"/> 게임하기<br/>

    <input type="submit" value="index4.jsp로 전송"/>

</form>

<%-- jsp에서 servlet로 전송 model 2 --%>
<h3>jsp에서 servlet로 전송</h3>
<form action="hello" method="post">
    이름 : <input type="text" name="name"/><br/>
    나이 : <input type="text" name="age"/><br/>
    좋아하는 과일 :
    <select name="fruits">
        <option value="grape">포도</option>
        <option value="banana">바나나</option>
        <option value="apple">사과</option>
    </select>
    <br/>

    <input type="checkbox" name="hobby" value="painting" /> 그림<br/>
    <input type="checkbox" name="hobby" value="music"/> 음악듣기<br/>
    <input type="checkbox" name="hobby" value="game"/> 게임하기<br/>

    <input type="submit" value="hello로 전송"/>

</form>

</body>
</html>
