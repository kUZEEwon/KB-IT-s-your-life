
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String fruit = request.getParameter("fruits");

    String[] hobbies = request.getParameterValues("hobby");
    // db 접근 가능
%>
<html>
<head>
    <title>index4.jsp</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>이름</th>
            <td><%=name%></td>
        </tr>
        <tr>
            <th>나이</th>
            <td><%=age%></td>
        </tr>
        <tr>
            <th>과일</th>
            <td><%=fruit%></td>
        </tr>
        <%
            for (int i = 0; i < hobbies.length; i++) {
        %>
        <tr>
            <th>취미</th>
            <td><%=hobbies[i]%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
