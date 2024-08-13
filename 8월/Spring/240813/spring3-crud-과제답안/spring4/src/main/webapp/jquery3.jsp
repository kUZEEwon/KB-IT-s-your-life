<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>결제 페이지</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(() => { //document.ready()와 동일
        // axios를 사용한 회원가입 ID 중복 체크
           $('#b1').click(function (){
                const userId = $('#userId').val();
                console.log(userId + "----")
                axios.get('/check?userId='+userId)
                    .then(response => {
                        $('#result').html(response.data);
                        console.log(response.data + "----")
                    })
                    .catch(error => {
                        console.error("ID 중복 체크 에러:", error);
                    });
           });


        // axios를 사용한 인증번호 받기
            $('#b2').click(function () {
                const phoneNumber = $('#phoneNumber').val();
                axios.get('/phone?phoneNumber=' + phoneNumber)
                    .then(response => {
                        $('#code').html(response.data);
                    })
                    .catch(error => {
                        console.error("인증번호 받기 에러:", error);
                    });
            });
                // axios를 사용한 결제하기
            $('#b3').click(function () {
                const amount = $('#paymentAmount').val();
                const choice = $('#paymentMethod').val();
                axios.post('/pay', null, {
                    params: {
                        amount: amount,
                        choice: choice
                    }
                })
                .then(response => {
                    console.log(response.data)
                    $('#result').html(response.data);
                })
                .catch(error => {
                    console.error("결제 에러:", error);
                });
            });
        });
    </script>
</head>

<body>

<h2>회원가입</h2>
    <label>회원가입할 ID입력: </label>
    <input type="text" id="userId" value="apple"/>
    <button type="button" id="b1" >axios로 ID중복 체크</button>
<hr color="red">

<h2>인증</h2>
    <label>인증받을 전화번호 입력: </label>
    <input type="text" id="phoneNumber" value="01122222996" />
    <button type="button" id="b2">axios로 인증번호 받기</button>
    <br>
    <span style="color: red"> 받은 인증 번호는 </span> <span id="code"> </span>
<hr color="red">

<h2>결제 페이지</h2>
    <label>결제금액: </label>
    <input type="text" id="paymentAmount" value="10000" /><br />
    <label>결제수단: 1)계좌이체 2)카드결제 3)기타(앱결제)</label>
    <input type="text" id="paymentMethod" value="1"/><br />
    <button type="button" id="b3">axios로 결제하기</button>
<hr color="blue">

<div id="result" style="background: yellow"></div>

</body>
</html>
