<%@ page import="hello.Human" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<H1>Hello Jsp</H1>

<%-- jsp 주석문 --%>
<!-- html 주석문 -->
<%--
    jsp : java server page

    HTML(JAVA)
    Get/Post -> Parameter을 노출

    Servlet
    Java(html)
--%>
    <%
        // scriptlet - java 영역
        // 가독성이 좋지 않고 무거운 프로그램이다.
        // 랜더링 시간이 오래 걸린다.
        /*
        * 내장 객체 : new를 통해서 생성하지 않고 바로 사용가능한 class
        *
        * out : 자바 안에 코드를 웹으로 출력해 주는 객체
        * request : 매개 변수의 값을 취득할 경우 사용하는 객체. 객체 자체를 전송시에도 사용
        *            getParameter, setAttribute, getAttribute
        * response : (web)이동 시에 사용
        *           sendRedirect
        * session : 저장 공간 -> login(사용자) 정보
        * pageContext : (web)이동 시에 사용
        *               forward
        * */

    %>

    <%
        for(int i = 1; i <= 10; i++){
    %>
    <p>p tag <%= i%></p>

    <%
        }
    %>

    <%-- Script의 종류
    <%!
        선언부 : 함수, 클래스, 전역변수
    %>

    <%
        코드부
        변수
    %>

    <%=
        값(변수)
    %>
--%>
<%!
    public void func(){
        System.out.println("func() 호출");
    }

    int g_number = 0;

%>

<%
    func();

    int number = 0;

    g_number++;
    number++;

    System.out.println("g_number = " + g_number);
    System.out.println("number = " + number);

    Human human = new Human("jiwon",25);
    System.out.println("human = " + human);
%>

<p>g_number : <%=g_number %></p>
<p>number : <%=number %></p>
</body>
</html>