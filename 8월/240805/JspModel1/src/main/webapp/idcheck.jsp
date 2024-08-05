<%@ page import="dao.MemberDao" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 24. 7. 30.
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");

    MemberDao dao = MemberDao.getInstance();
    boolean b = dao.getId(id);

    String answer = "YES";
    if (b) {
        answer = "NO";
    }
    out.println(answer);
%>
