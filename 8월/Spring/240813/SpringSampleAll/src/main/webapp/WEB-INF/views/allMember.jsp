<%@ page import="java.util.List" %>
<%@ page import="mul.cam.e.dto.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<MemberDto> list = (List<MemberDto>) request.getAttribute("list");
%>
<html>
<head>
    <title>All Members</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>All Members</h1>

<table>
    <tr>
        <th>번호</th>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
    </tr>
    <%
        for(int i = 0; i < list.size(); i++) {
            MemberDto dto = list.get(i);
    %>
    <tr>
        <td><%= i + 1 %></td>
        <td><%= dto.getId() %></td>
        <td><%= dto.getPw() %></td>
        <td><%= dto.getName() %></td>
        <td><%= dto.getEmail() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
