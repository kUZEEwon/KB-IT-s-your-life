<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%
    // spring security 에서 사용자 정보를 찾는 경우
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String name = "";
    if(auth.getPrincipal() != null){
        name = auth.getName();  // = username
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>index</h2>

<%-- 로그인이 안된 경우--%>
<sec:authorize access="isAnonymous()">
    <h5>
            <a href="/loginPage">login</a>
    </h5>
</sec:authorize>

<%-- 로그인이 된 경우--%>
<sec:authorize access="isAuthenticated()">
    <h5><%=name %>님 반갑습니다</h5>
    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">logout</button>
    </form>
</sec:authorize>

<button type="button" onclick="location.href='home'">home</button>
<button type="button" onclick="location.href='user/page'">user/page</button>
<button type="button" onclick="location.href='admin/page'">admin/page</button>

</body>
</html>
