<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <style type="text/css">
        .center{
            margin: auto;
            width: 60%;
            border: 3px solid #0000ff;
            padding: 10px;
        }
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

</head>
<body>

<h2>login</h2>

<div class="center">
    <form action="loginAf.do" method="post">

        <table border="1">
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" id="id" name="id" size="20"><br/>
                    <input type="checkbox" id="chk_saveid">아이디저장
                </td>
            </tr>
            <tr>
                <th>패스워드</th>
                <td>
                    <input type="password" name="pw" size="20">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="로그인">
                    <a href="regi.do">회원가입</a>
                </td>
            </tr>

        </table>

    </form>
</div>

<script>

    let user_id = $.cookie("user_id");
    if(user_id != null){    // cookie 가 있음
        $("#id").val( user_id );
        $("#chk_saveid").prop("checked", true);
    }

    $("#chk_saveid").click(function () {
        // alert('check');
        if( $("#chk_saveid").is(":checked") ){
            if( $("#id").val().trim() === "" ){
                alert("아이디를 입력해 주십시오");
                $("#chk_saveid").prop("checked", false);
            }else{
                $.cookie("user_id", $("#id").val().trim())
            }
        }
        else{   // checkbox == false
            $.removeCookie("user_id", { path:'./' });
        }
    });


</script>



</body>
</html>
