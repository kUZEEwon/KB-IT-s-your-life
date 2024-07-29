<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index3</title>
</head>
<body>
    <h3>Index3.jsp</h3>

<%--
    String name = request.getParameter("name");
--%>
    <%
        String name = (String) request.getAttribute("name"); // 타입 변환을 해주어야 한다.

    %>

   <h4>name : <%=name%></h4>
</body>
</html>
