<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- response --%>
    <%--
        String name = "mymelody";
        name = URLEncoder.encode(name, "UTF-8");
        response.sendRedirect("index3.jsp?name=" + name); // 어디로 이동할건지
    --%>

    <%
        String name = "mymelody";
        request.setAttribute("name", name); // 짐싸
       // pageContext.forward("index3.jsp");  // 잘가!(이동)
        response.sendRedirect("index3.jsp");
    %>
</body>
</html>
