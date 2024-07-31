
<%@ page import="dto.MemberDto" %>
<%@ page import="dao.MemberDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>회원가입 결과</title>
  <meta charset="UTF-8">
</head>
<body>
<%
  request.setCharacterEncoding("UTF-8");

  // 파라미터 가져오기
  String id = request.getParameter("id");
  String pw = request.getParameter("pw");
  String name = request.getParameter("name");
  String email = request.getParameter("email");

  // 유효성 검사
  if (id == null || pw == null || name == null || email == null ||
          id.trim().isEmpty() || pw.trim().isEmpty() || name.trim().isEmpty() || email.trim().isEmpty()) {
%>
<script>
  alert("모든 필드를 입력해 주세요.");
  location.href = "account.jsp";
</script>
<%
    return;
  }

  // DTO 객체 생성
  MemberDto mem = new MemberDto(id, pw, name, email, 0);

  // DAO를 통해 데이터베이스에 저장
  MemberDao dao = MemberDao.getInstance();
  boolean isS = dao.insertMember(mem);

  if (isS) {
%>
<script>
  alert("성공적으로 가입되었습니다.");
  location.href = "login.jsp";
</script>
<%
} else {
%>
<script>
  alert("가입에 실패했습니다. 다시 시도해 주세요.");
  location.href = "account.jsp";
</script>
<%
  }
%>
</body>
</html>
