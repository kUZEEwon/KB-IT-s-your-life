<%@ page import="com.multi.web04_mvc2.dto.ProductDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>모든 상품 정보</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h2>모든 상품 정보</h2>

<table>
    <thead>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>가격</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<ProductDto> products = (List<ProductDto>) request.getAttribute("products");
        if (products != null && !products.isEmpty()) {
            for (ProductDto product : products) {
    %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">등록된 상품이 없습니다.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
