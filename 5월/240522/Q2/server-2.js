// 각 요청 주소에 맞는 html 파일을 서빙하여 요청 시 브라우저에 출력되도록 프로그래밍 하시오.

const http = require('http');
const fs = require('fs');

const server = http.createServer((req, res) => {
    const { method, url } = req;

    // 라우팅
    if (method === "GET" && url === "/") {
        res.statusCode = 200;
        const readStream = fs.createReadStream(__dirname + "/index.html", "utf-8");
        readStream.pipe(res);
    } else if (method === "GET" && url === "/home") {
        res.statusCode = 200;
        const readStream = fs.createReadStream(__dirname + "/home.html", "utf-8");
        readStream.pipe(res);
    } else if (method === "GET" && url === "/contact") {
        res.statusCode = 200;
        const readStream = fs.createReadStream(__dirname + "/contact.html", "utf-8");
        readStream.pipe(res);
    } else {
        res.statusCode = 404;
        res.end('Not Found');
    }
    
});

server.listen(3000, () => {
    console.log(`3000번 포트에서 서버 실행 중...`)
})