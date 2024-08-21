<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>  <!-- 페이지 설정: Java 언어 사용, 컨텐츠 타입 및 인코딩 UTF-8로 설정 -->
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">  <!-- 문서의 문자 인코딩을 UTF-8로 설정 -->
  <title>Bank Chatbot</title>  <!-- 웹페이지 제목 설정 -->

  <!-- jQuery 라이브러리 로드 -->
  <script type="text/javascript"
          src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

  <!-- Bootstrap CSS 로드 -->
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

  <!-- Bootstrap JavaScript 로드 -->
  <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

  <!-- SockJS 라이브러리 로드 -->
  <script type="text/javascript" src="resources/js/sockjs-0.3.4.js"></script>

  <!-- STOMP 라이브러리 로드 -->
  <script type="text/javascript" src="resources/js/stomp.js"></script>

  <script type="text/javascript">
    var stompClient = null;  // stompClient 변수 초기화

    // 연결 상태에 따라 UI 업데이트
    function setConnected(connected) {
      document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
      document.getElementById('response').innerHTML = '';
    }

    // WebSocket 서버에 연결
    function connect() {
      var socket = new SockJS('${pageContext.request.contextPath}/chat2');  // SockJS를 사용하여 서버에 연결
      stompClient = Stomp.over(socket);  // STOMP 프로토콜을 사용하기 위한 클라이언트 생성

      // STOMP 서버에 연결 및 구독
      stompClient.connect({}, function(frame) {
        setConnected(true);
        alert('연결됨. ' + frame);  // 연결 성공 시 알림
        stompClient.subscribe('/topic/messages2', function(messageOutput) {
          showMessageOutput(JSON.parse(messageOutput.body));  // 메시지 수신 시 처리
        });
      });
    }

    // 메시지 전송 함수
    function sendMessage() {
      var from = "guest";  // 보낸 사람 정보 설정
      var text = document.getElementById('text').value;  // 입력된 텍스트 가져오기
      stompClient.send("/app/chat2", {}, JSON.stringify({
        'from' : from,
        'text' : text
      }));  // 서버로 메시지 전송
    }

    // 수신된 메시지를 화면에 출력
    function showMessageOutput(messageOutput) {
      var response = document.getElementById('response');  // 메시지를 출력할 위치
      var p = document.createElement('p');  // 새로운 문단 요소 생성
      p.style.wordWrap = 'break-word';  // 단어가 너무 길 경우 줄바꿈 처리
      p.appendChild(document.createTextNode(messageOutput.menu));  // 메시지 텍스트 추가
      response.appendChild(p);  // 메시지를 화면에 추가
    }

    // 연결 해제 함수
    function disconnect() {
      if (stompClient != null) {
        stompClient.disconnect();  // 연결이 되어있으면 연결 해제
      }
      setConnected(false);  // 연결 상태 업데이트
      console.log("Disconnected");  // 콘솔에 연결 해제 로그 출력
    }

  </script>
</head>
<body onload="connect();">  <!-- 페이지 로드 시 자동으로 connect() 함수 호출 -->
<br>
<br>
<!-- 챗봇 이미지 로드 -->
<img src="resources/image/chat1.png" width="100" height="100">
<img src="resources/image/chat4.png" width="400" height="100">

<div class="alert alert-primary" style="width: 500px;">
  <!-- 기본 챗봇 메뉴 표시 -->
  <div>챗 봇>> 1) 은행거래 2) 대출거래</div>
  <br>
  <div id="response">  <!-- 메시지가 출력될 위치 -->

  </div>
  <div class="form-floating mb-3 mt-3" id="conversationDiv">  <!-- 채팅 입력 UI -->
    <table>
      <tr>
        <!-- 사용자가 입력할 텍스트 필드 -->
        <td><input type="text" class="form-control" id="text" style="width: 400px; background: yellow"></td>
        <!-- 메시지 전송 버튼 -->
        <td><button id="sendMessage" onclick="sendMessage();"class="btn btn-primary">Send</button></td>
      </tr>
    </table>
  </div>
</div>
</body>
</html>
