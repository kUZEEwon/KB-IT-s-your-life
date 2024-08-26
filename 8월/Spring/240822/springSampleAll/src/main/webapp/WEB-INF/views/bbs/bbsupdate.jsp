<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

  <style>
    .center{
      margin: auto;
      width: 800px;
    }
    th{
      background-color: #007bff;
      color: white;
      text-align: center;
      vertical-align: middle;
    }
  </style>
</head>
<body>

<h2>글수정</h2>

<div class="center">

<form action="bbsupdateAf.do">
  <input type="hidden" name="seq" value="${bbs.seq}">

  <table class="table table-sm">
    <col width="30px"/><col width="170px"/>

    <tr>
      <th>아이디</th>
      <td>
        ${bbs.id}
      </td>
    </tr>
    <tr>
      <th>제목</th>
      <td>
        <input type="text" name="title" size="50px" class="form-control form-control-lg" value="${bbs.title}"/>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <textarea rows="18" name="content" class="form-control">${bbs.content}</textarea>
      </td>
    </tr>
  </table>

  <input type="submit" class="btn btn-primary" value="글수정 완료">

</form>

</div>

</body>
</html>
