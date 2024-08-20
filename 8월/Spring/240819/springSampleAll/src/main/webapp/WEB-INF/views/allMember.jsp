<%@ page import="java.util.List" %>
<%@ page import="mul.cam.e.dto.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<MemberDto> list = (List<MemberDto>)request.getAttribute("list");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>All Member</h1>

    <table border="1">
        <tr>
            <th>번호</th><th>ID</th><th>PW</th><th>Name</th><th>Email</th>
        </tr>
        <%
            for(int i = 0; i < list.size(); i++){
                MemberDto dto = list.get(i);
                %>
                <tr>
                    <th><%=i + 1 %></th>
                    <td><%=dto.getId() %></td>
                    <td><%=dto.getPw() %></td>
                    <td><%=dto.getName() %></td>
                    <td><%=dto.getEmail() %></td>
                </tr>
                <%
            }
        %>
    </table>

</body>
</html>
