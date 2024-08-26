<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div align="center">

    <h2>기본글</h2>

    <table border="1">
        <col width="200"/><col width="500"/>
        <tr>
            <th>작성자</th>
            <td>${bbs.id}</td>
        </tr>
        <tr>
            <th>작성일</th>
            <td>${bbs.wdate}</td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${bbs.readcount}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${bbs.title}</td>
        </tr>
        <tr>
            <td colspan="2">
                ${bbs.content}
            </td>
        </tr>
    </table>
    <br/>

    <form action="bbsanswerAf.do" method="post">
        <input type="hidden" name="seq" value="${bbs.seq}">

        <table border="1">
            <col width="200"/><col width="500"/>
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" size="50" name="id" value="${login.id}" readonly>
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" size="50", name="title">
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea rows="10" cols="50" name="content" placeholder="내용"></textarea>
                </td>
            </tr>
        </table>
        <br/>
        <input type="submit" value="답글 작성완료">

    </form>
</div>
</body>
</html>
