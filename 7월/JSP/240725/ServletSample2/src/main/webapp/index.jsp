<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<br/><br/>

<form action="hello-servlet" method="post">
    이름 : <input type="text" name="name"/><br/>
    나이 : <input type="text" name="age"/><br/>

    <select name="fruit">
        <option value="apple">사과</option>
        <option value="pear">배</option>
        <option value="grape">포도</option>
    </select>
    <br/>
    <input type="submit" value="hello">
</form>
</body>
</html>