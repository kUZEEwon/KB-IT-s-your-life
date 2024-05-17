// Socket : network의 정보(7layer)

const http = require('http');

const server = http.createServer();

const port = 3000;
server.listen(port,() => {
    console.log(`웹 서버가 시작되었어요.\nport번호  :   ${port}`);
});

// 클라이언트 연결 이벤트 처리
server.on('connection', (socket) => {
    let addr = socket.address(); // 접속한 부분의 주소

    console.log(`클라이언트가 접속했어요. ${addr.address}, ${addr.port}`); // 1번 요청, 2번 감지
});

// 클라이언트 요청 이벤트 처리
server.on('request', (request, response) => {
    console.log(`클라이언트 요청이 들어왔어요.`);
    // console.dir(request);

    response.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
    response.write("<!DOCTYPE html>");

    response.write("<html>");

    response.write("<head>");
    response.write("<title>응답페이지</title>");
    response.write("</head>");

    response.write("<body>");
    response.write("<h1>반가워요, 응답 html 이에요.</h1>");
    response.write("</body>");


    response.write("</head>");

    response.write("</html>");
})

// 서버 종료 처리
server.on('close', ()=> {
    console.log(`server close`);
})

/* server.close(() => {
    console.log(`서버가 종료되요`);
})  */