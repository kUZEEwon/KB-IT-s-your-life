<%@ page import="mul.cam.e.dto.TestBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<%-- core tag : 제어문
    <c:if test="${조건}">
        <c:out value="내용"/>
    </c:if>

    <c:forEach var="item" items="${리스트}">
        <c:out value="${item}"/>
    </c:forEach>
--%>

<%-- JSP 스크립틀릿을 사용하여 request 속성을 설정할 수 있지만, JSTL의 <c:set>을 사용하는 것이 더 좋습니다. --%>

<%
    // request.setAttribute("apple", "사과");
%>

<%-- set --%>
<c:set var="apple" value="사과" />

<%-- out --%>
<c:out value="${apple}" />
<br/>
${apple}
<br/>

<%-- if --%>
<%
    // request 속성으로 "count" 값을 설정
    request.setAttribute("count", 10);
%>
<%
    // request 속성에서 "count" 값을 읽어 정수로 변환
    Integer count = (Integer) request.getAttribute("count");

    if (count != null && count >= 5) {
%>
count : <%= count %>
<%
    }
%>

<br/>
<c:if test="${count >= 5}">
    count: ${count}
</c:if>

<%--<c:if test="${ empty login }">
&lt;%&ndash;    &ndash;%&gt;
</c:if>--%>

<br/><br/>

<%
    request.setAttribute("name","마이멜로디");
%>
<c:if test="${name eq '마이멜로디'}" var="flg" />

<c:out value="${flg}"/><br/>
<c:if test="${flg}">
    이름이 마이멜로디에요
</c:if>
<br/>
<%-- for --%>
<%
    for(int i=0; i<10; i++){
        %>
                <%= i+1 %>
        <%
    }
%>
<br/>

<c:forEach begin="0" end="9" step="1" varStatus="i">
    ${ i.index +1 }
</c:forEach>
<br/><br/>

<%
    List<TestBean> list = new ArrayList<>();

    TestBean b = new TestBean();
    b.setMessage("안녕");
    list.add(b);

    b = new TestBean();
    b.setMessage("하이");
    list.add(b);

    b = new TestBean();
    b.setMessage("굿데이");
    list.add(b);

    request.setAttribute("list", list);
%>

<%
    for(int i=0; i<list.size(); i++){
        TestBean t = list.get(i);
    }
%><br/>


<c:forEach var="t" items="${ list }" varStatus="i">
    index: ${ i.index }
    message: ${t.message}
    <br/>
</c:forEach>

<%
    Map<String, String> map = new HashMap<>();
    map.put("apple","사과");
    map.put("pear", "배");
    map.put("grape", "포도");

    request.setAttribute("map", map);
%><br/>

<c:forEach var="fruit" items="${map}">
    key : ${ fruit.key }
    value: ${ fruit.value }
    <br/>
</c:forEach><br/>


<%--
        jsp : include
       외부 파일 불러오기, 객체 생성할 때 사용
--%>
    <h2>hello start</h2>
        <jsp:include page="info.jsp" flush="false"/>
    <h2>hello end</h2>

<%--    <jsp:forward page="info.jsp" />--%>

<%--<%
    TestBean tb = new TestBean();
    tb.setMessage("message");
    String s = tb.toString();
%>--%>

<jsp:useBean id="tb" class="mul.cam.e.dto.TestBean" />
<jsp:setProperty name="tb" property="message" value="message" />
message : <jsp:getProperty name="tb" property="message"/>
</body>
</html>
