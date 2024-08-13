<%@ page import="mul.cam.e.dto.HumanDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Home.jsp</h1>

    <br/><br/>

    <%-- Shift + Ctrl + Alt + L --%>

    <%-- 1 --%>
    <a href="hello.do">hello로 이동</a>
    <%
        String name = (String)request.getAttribute("name");
    %>
    <br/><br/>
    name: <%=name %>

    <br/><br/>

    <%-- 2 --%>
    <form action="info.do" method="post">
    <table>
        <tr>
            <td>이름</td>
            <td>
                <input type="text" name="name" placeholder="이름">
            </td>
        </tr>
        <tr>
            <td>나이</td>
            <td>
                <input type="text" name="age" placeholder="나이">
            </td>
        </tr>
    </table>
        <input type="submit" value="info로 이동">
    </form>

    <br/><br/>

    <%-- 3 --%>
    <a href="list.do">info로 이동</a>
    <%
        List<HumanDto> list = (List<HumanDto>)request.getAttribute("list");
        if(list != null && list.size() > 0){
    %>
    <table border="1">
        <tr>
            <th>이름</th><th>나이</th>
        </tr>
        <%
            for(int i = 0;i < list.size(); i++){
                HumanDto s = list.get(i);
        %>
        <tr>
            <td><%=s.getName() %></td>
            <td><%=s.getAge() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        }
    %>


</body>
</html>
