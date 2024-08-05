<%@ page import="com.multi.web04_mvc2.dto.CustomerDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>고객정보 처리 결과를 담는 페이지</title>
</head>
<body>
<br/>
<a href="/customer_list">모든 고객 목록 보기</a>
<br/>
<hr color="blue"/>

<h3>삽입 정보</h3>
<%
    CustomerDto customer = (CustomerDto) request.getAttribute("customer");
    if (customer != null) {
%>
추가한 고객 정보 :
<ul>
    <li>아이디: <%= customer.getId() %></li>
    <li>이름: <%= customer.getName() %></li>
    <li>이메일: <%= customer.getEmail() %></li>
</ul>
<%
} else {
%>
고객 정보가 없습니다.
<%
    }
%>

<hr color="red">

<h3>삭제 정보</h3>
<%
    String customerId = (String) request.getAttribute("customer_id");
    if (customerId != null) {
%>
삭제된 고객 아이디 : <%= customerId %>
<%
} else {
%>
삭제된 고객 아이디가 없습니다.
<%
    }
%>

</body>
</html>
