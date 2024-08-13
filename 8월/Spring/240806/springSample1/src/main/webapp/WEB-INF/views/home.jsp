<%@ page import="java.util.List" %>
<%@ page import="mul.cam.e.dto.HumanDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
    <h1>Home.jsp</h1>

    <br/><br/>

    <%-- 1 --%>
    <a href="hello.do">hello으로 이동하기</a>
    <%
        String name = (String) request.getAttribute("name");
    %>
    <br/><br/>
    name : <%=name%>
    <br/><br/>

<%--2--%>
<%-- 뷰에서 컨트롤러로 --%>
    <form action="info.do" method="post">
        <table>
            <tr>
                <td>이름</td>
                <td>
                    <input type="text" name="name" placeholder="이름"/>
                </td>
            </tr>
            <tr>
                <td>나이</td>
                <td>
                    <input type="text" name="age" placeholder="나이"/>
                </td>
            </tr>
        </table>
        <input type="submit" value="info로 이동"/>
    </form>
<%--3 --%>
    <br/><br/>

    <%
        List<HumanDto> list = (List<HumanDto>) request.getAttribute("list");
    %>
    <h3>list.do 에서 받아온 리스트</h3>
    <a href="list.do">list내용 받아오기</a>
    <br/><br/>
    <table>
        <tr>
            <th>이름</th>
            <th>나이</th>
            <!-- 필요한 다른 필드들 추가 -->
        </tr>
            <%
        if (list != null) {
            for (HumanDto human : list) {
    %>
        <tr>
            <td><%= human.getName() %></td>
            <td><%= human.getAge() %></td>
            <!-- 필요한 다른 필드들 추가 -->
        </tr>
            <%
            }
        } else {
    %>
        <tr>
            <td colspan="2">리스트가 비어 있습니다.</td>
        </tr>
            <%
        }
    %>

</body>
</html>
