<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<br><br>
<div class="container text-center">
    <h1>Access Deined(접근불가)</h1><br>
</div>
<br><br>
<div class="container text-center">
    <h6 class="font-italic text-danger">권한이 없어 접근이 불가합니다.<br>관리자에게 문의하세요.</h6>
</div>
<br><br>
<div class="container text-center">
    <a href='<c:url value="/"/>' class="text-dark"><i class="fas fa-undo">처음으로</i></a>
</div>


</body>
</html>
