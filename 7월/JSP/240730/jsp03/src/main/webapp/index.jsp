<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JSP - Hello World</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .container {
      text-align: center;
      padding: 20px;
      border-radius: 8px;
      background-color: #ffffff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
      color: #333;
      margin-bottom: 20px;
    }
    a {
      display: block;
      text-decoration: none;
      color: #007BFF;
      font-size: 18px;
      margin: 10px 0;
      transition: color 0.3s ease;
    }
    a:hover {
      color: #0056b3;
    }
    .link-container {
      max-width: 300px;
      margin: 0 auto;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>JSP 페이지 링크</h1>
  <div class="link-container">
    <a href="login.jsp">로그인 페이지</a>
    <a href="input.jsp">입력 폼 페이지</a>
    <a href="sessionSet.jsp">세션 값 확인 페이지</a>
    <a href="sessionGet.jsp">세션 값 설정 페이지</a>
    <a href="cookieSend.jsp">쿠키 전송 페이지</a>
    <a href="cart.jsp">장바구니 페이지</a>
    <a href="adTracker.jsp">광고 추적 페이지</a>
    <a href="trackUser.jsp">사용자 추적 페이지</a>
  </div>
</div>
</body>
</html>
