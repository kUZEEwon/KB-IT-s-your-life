<%@ page import="com.multi.web04_mvc2.dto.ProductDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상품정보 처리 결과를 담는 페이지</title>
</head>
<body>
<br/>
<a href="/product_list">모든 상품 목록 보기</a>
<br/>

<hr color="blue"/>

<h3>삽입 정보</h3>
<%
    ProductDto product = (ProductDto) request.getAttribute("product");
    if (product != null) {
%>
추가한 상품 정보 :
<ul>
    <li>아이디: <%= product.getId() %></li>
    <li>이름: <%= product.getName() %></li>
    <li>가격: <%= product.getPrice() %></li>
</ul>
<%
} else {
%>
상품 정보가 없습니다.
<%
    }
%>

<hr color="red">

<h3>삭제 정보</h3>
<%
    String productId = (String) request.getAttribute("product_id");
    if (productId != null) {
%>
삭제된 상품 아이디 : <%= productId %>
<%
} else {
%>
삭제된 상품 아이디가 없습니다.
<%
    }
%>

</body>
</html>
