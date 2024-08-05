
<%@ page import="java.util.List" %>
<%@ page import="com.multi.web04_mvc2.dto.CustomerDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>모든 고객 정보</title>
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
<h2>모든 고객 정보</h2>

<table>
    <thead>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<CustomerDto> customers = (List<CustomerDto>) request.getAttribute("customers");
        if (customers != null && !customers.isEmpty()) {
            for (CustomerDto customer : customers) {
    %>
    <tr>
        <td><%= customer.getId() %></td>
        <td><%= customer.getName() %></td>
        <td><%= customer.getEmail() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">등록된 고객이 없습니다.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
