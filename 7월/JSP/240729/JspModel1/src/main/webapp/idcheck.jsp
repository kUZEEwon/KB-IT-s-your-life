<%@ page import="dao.MemberDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");

    MemberDao dao = MemberDao.getInstance();
    boolean b = dao.getId(id);

    String ans = "YES";
    if(b){
        ans = "NO";
    }

    out.print(ans);
%>