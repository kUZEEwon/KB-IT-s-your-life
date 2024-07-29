<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- request --%>

<%--나이 : <input type="text" name="age" />--%>

<%
    // getParameter( "name" )
    String name = request.getParameter("name");
    String age = request.getParameter("age");

    String[] hobby = request.getParameterValues("hobby"); // select, checkbox

    System.out.println("name : " + name);

    System.out.println("age : " + age);

    System.out.println("hobby : " + Arrays.toString(hobby));

    out.println("name : " + name + "<br>");
    out.println("age : " + age + "<br>");


    // getAttribute( object );
%>
</body>
</html>
