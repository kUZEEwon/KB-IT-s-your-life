<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<%
    // 가입 처리 결과 확인
    String message = (String) request.getAttribute("message");
    if (message != null && !message.equals("")) {
        if (message.equals("MEMBER_YES")) {
%>
<script>
    alert("성공적으로 가입되었습니다.");
    location.href = "login.jsp";
</script>
<%
} else {
%>
<script>
    alert("다시 가입해주세요");
    location.href = "account.jsp";
</script>
<%
        }
    }

    // 로그인 처리 결과 확인
    String login = (String) request.getAttribute("login");
    if (login != null && !login.equals("")) {
        if (login.equals("LOGIN_OK")) {
%>
<script>
    alert("환영합니다");
    location.href = "Bbs?param=bbslist";
</script>
<%
} else {
%>
<script>
    alert("아이디나 패스워드를 확인해주세요.");
    location.href = "Member?param=login";
</script>
<%
        }
    }

    // 글 작성 처리 결과 확인
    String bbswrite = (String) request.getAttribute("bbswrite");
    if (bbswrite != null && !bbswrite.equals("")) {
        if (bbswrite.equals("BBSWRITE_OK")) {
%>
<script>
    alert("글 작성 성공!");
    location.href = "Bbs?param=bbslist";
</script>
<%
} else {
%>
<script>
    alert("다시 작성해 주십시오");
    location.href = "bbswrite.jsp";
</script>
<%
        }
    }

    // 글 수정 처리 결과 확인
    String bbsupdate = (String) request.getAttribute("bbsupdate");
    if (bbsupdate != null && !bbsupdate.equals("")) {
        if (bbsupdate.equals("BBSUPDATE_OK")) {
%>
<script>
    alert("글 수정 성공!");
    location.href = "Bbs?param=bbslist";
</script>
<%
} else {
%>
<script>
    alert("다시 수정해 주십시오");
    location.href = "bbsupdate.jsp?seq=<%= request.getAttribute("seq") %>";
</script>
<%
        }
    }
%>
</body>
</html>
