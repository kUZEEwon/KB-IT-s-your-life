
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>

    ID : <input type="text" id="id" /><br/><br/>
    <button type="button" onclick="idCheck()">
        아이디 체크
    </button>

    <script>
        function  idCheck(){
            $.ajax({
                url: "idcheck.do",
                type: "get",
                data: {id: $("#id").val()},
                success: function (msg) { // 컨트롤러의 ans가 넘겨진다.
                    alert(msg);
                },
                error: function () {
                    alert("error");
                }
            });
        }
    </script>
    <br/><br/>
    <%--
        web(json) => controller(object)
        controller(object) => web(json)
    --%>

    이름 : <input type="text" id="name" value="멜로디" /><br/>
    이메일 : <input type="email" id="email" value="abc@pusan.ac.kr" /><br/>
    생년월일 : <input type="text" id="birth" value="2000/11/27" /><br/>
    <button type="button" onclick="account()">회원 가입</button>

    <script>
        function account(){
            let human = {
                name : $("#name").val(),
                email : $("#email").val(),
                birth : $("#birth").val()
            };

            $.ajax({
                url: "account.do",
                type: "post",
                dataType :"json",
                data : human,
                async : true,
                success: function (data){
                    alert(data.message);
                  //  alert(JSON.stringify(data));
                },
                error: function () {
                    alert("error");
                }
            })
        }
    </script>
</body>
</html>
