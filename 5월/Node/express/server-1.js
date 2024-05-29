const express = require('express');
const app = express(); // npm i express

const cors = require(`cors`); // npm i cors

app.use(cors({
    origin: 'http://localhost:5500' // (접속) 허용된 origin
    // origin: '*' // 모두 허용한다.
}));

app.get(`/`, (req, res) => {
    console.log(`/접속성공!`);
    /* 
        res.writeHead(200, { "Content-Type": "text/html; charset=utf-8" });
        res.write("<!DOCTYPE html>");
    
        res.write("<html>");
    
        res.write("<head>");
        res.write("<title>응답페이지</title>");
        res.write("</head>");
    
        res.write("<body>");
        res.write("<h1>반가워요, 응답 html 이에요.</h1>");
        res.write("</body>");
    
    
        res.write("</head>");
    
        res.write("</html>"); */


    // url을 통해서 data를 전송하고 취득하는 처리를 => Restful 

    res.end('Hello Express');
});

const listener = app.listen(3000, () => {
    console.log(`express server start port : ${listener.address().port}`);
});