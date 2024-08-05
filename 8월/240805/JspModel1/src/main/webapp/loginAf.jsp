<%@ page import="dao.MemberDao" %>
<%@ page import="dto.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");

    MemberDao dao = MemberDao.getInstance();
    MemberDto member = dao.login(id, pw);
    if(member != null) {
        // session 에 저장
        session.setAttribute("login", member);
        // request.getSession().setAttribute("login", member);
        session.setMaxInactiveInterval(60 * 60 * 24 * 7);
        %>
        <script>
            alert('안녕하세요 <%=member.getId() %>님');
            location.href = "./bbslist.jsp";
        </script>
        <%
    }else{
        %>
        <script>
            alert('id나 password를 확인해 주십시오');
            location.href = "./login.jsp";
        </script>
        <%
    }
%>
