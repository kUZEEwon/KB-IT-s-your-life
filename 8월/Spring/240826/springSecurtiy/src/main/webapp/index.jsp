<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContext" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%
    // spring security에서 사용자 정보를 찾는 경우
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String name = "";
    if (auth.getPrincipal() != null) {
        name = auth.getName(); // username
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Index.jsp</title>
</head>
<body>
<h2>index</h2>

<%--로그인 여부 확인--%>
<%--로그인이 안된 경우--%>
<sec:authorize access="isAnonymous()">
    <h5>
        <a href="/loginPage" >로그인</a>
    </h5>
</sec:authorize>

<%--로그인이 되어있는 경우--%>
<sec:authorize access="isAuthenticated()">
    <h5>
        <%=name%>님 반갑습니다.
    </h5>

    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">로그아웃</button>
    </form>
</sec:authorize>
<br/>
<button type="button" onclick="location.href='home'">home</button>
<button type="button" onclick="location.href='user/page'">user/page</button>
<button type="button" onclick="location.href='admin/page'">admin/page</button>

<br/><br/>

</body>
</html>