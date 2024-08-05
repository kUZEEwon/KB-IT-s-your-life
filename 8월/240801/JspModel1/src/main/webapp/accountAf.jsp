<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dto.MemberDto" %>
<%@ page import="dao.MemberDao" %>

<%
    request.setCharacterEncoding("utf-8");

    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    MemberDto mem = new MemberDto(id, pw, name, email, 0);
    System.out.println(mem.toString());

    MemberDao dao = MemberDao.getInstance();
    boolean isS = dao.insertMember(mem);
    if(isS){
        %>
        <script>
        alert("성공적으로 가입되었습니다");
        location.href = "login.jsp";
        </script>
        <%
    }else{
        %>
        <script>
        alert("다시 가입해 주십시오");
        location.href = "account.jsp";
        </script>
        <%
    }
    %>

