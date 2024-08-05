<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상품정보 처리 결과를 담는 페이지</title>
</head>
<body>
<br/>
<hr color="blue"/>

<h3>insert 정보</h3>
추가한 상품 정보 : <%= request.getAttribute("product")%>

<hr color="red">

<h3>delete 정보</h3>
삭제된 상품 아이디 : <%= request.getAttribute("product_id")%>

</body>
</html>
