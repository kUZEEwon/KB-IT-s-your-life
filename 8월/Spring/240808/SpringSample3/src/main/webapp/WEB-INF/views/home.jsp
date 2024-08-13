<%@ page import="mul.cam.e.dto.TestBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>홈 화면 입니다.</h1>

    <%--
        JSTL(Java Server Page Standard Tag Library)

            표현식
        EL(Expression Language)     -> 값을 표현하는 태그

            ${ 값, 연산, 삼항 연산자 }

        Core()                      -> 제어문(if, for  -> tag)
        Jsp                         -> 객체 생성, 화면 구성
    --%>

    <%
        String str = "Today Hello";
        request.setAttribute("str", str);
    %>

    <%
        String s = (String)request.getAttribute("str");
    %>

    <%=s %><br/>

    <%-- 다른 방법 --%>
    <%
        out.println(s);
    %><br/>

    ${str}
    <br/><br/>
    <input type="text" value="<%=s %>"/>
    <br/><br/>

    <input type="text" value="${str}" />
    <br/><br/>

    <%= 1 + 2 +3%>
    <br/><br/>
    ${1 + 2 +3 }
    <br/><br/>

    ${ 3 >1? 100:90}
    <br/><br/>

    <%
        request.setAttribute("key", "하이");
    %>
    ${key}

    <br/><br/>

    <%
        request.setAttribute("name", "홍길동");
    %>
    name = ${empty name}   <%-- name == null 인지 확인--%>
    <br /><br/>
    name = ${ not empty name }

    <br /><br/>
    <%
        request.setAttribute("numberOne", 10);
        request.setAttribute("numberTwo", 3);

        request.setAttribute("answer", true);
    %>

    <pre>
        numberOne: ${ numberOne }
        numberTwo : ${numberTwo}
        answer : ${ answer }

        numberOne + numberTwo : ${ numberOne + numberTwo }

        eq : ${ numberOne eq numberTwo }

        ne : ${ numberOne ne numberTwo }

        lt : ${ numberOne lt numberTwo }
    </pre>


<%
    TestBean bean = new TestBean();
    bean.setMessage("하이 EL");

    request.setAttribute("bean", bean);
%>

<%= bean.getMessage() %>
<br/>
${ bean.message }

<%
    String arrStr[] = {"apple", "pear"};
    request.setAttribute("arrStr", arrStr);
%>
    <br/>
    <%= arrStr[0]%>
    <br/>
   ${arrStr[0]}
    <br/>
<%
    List<String> list = new ArrayList<>();
    list.add("apple");
    list.add("pear");

    request.setAttribute("list", list);
%>
    <br/>
<%= list.get(1)%>
    <br/>
${ list[1] }
<br/>

<%
    List<TestBean> tList = new ArrayList<>();
    TestBean obj = new TestBean();
    obj.setMessage("안녕하세요");
    tList.add(obj);

    obj = new TestBean();
    obj.setMessage("반갑습니다.");
    tList.add(obj);

    request.setAttribute("tList", tList);
%>
<%=tList.get(1).getMessage() %>
<br/>
${ tList[1].message }

    <br/><br/>
    <%
        Map<String, String > map = new HashMap<>();
        map.put("apple", "사과");
        map.put("pear", "배");

        request.setAttribute("map", map);
    %>

    <%=map.get("apple")%>
    <br/>
    ${map.apple }
</body>
</html>