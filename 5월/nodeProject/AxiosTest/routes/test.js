const express = require('express');
const cors = require('cors');

const app = express.Router();
app.use(cors());

// parameter를 받기 위해서 설정
const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false}));

// 1.
app.get('/', function(req,res){
    console.log("/ 접속");
    res.send("안녕하세요");
});

// 2.
app.get('/test', function(req,res){
    console.log("/test 접속");
    res.send({"test" : "ok"});
});

// 3.
app.get('/human', function(req,res){
    console.log("/human 접속");

    let human = { 'id':'abc', 'name':'홍길동', 'height':172.1 };

    res.send(human);
});

// 4.
app.get("/conn_param",(req,res) => {
    console.log("/conn_param 접속");

    let number = req.query.number; // <- get 방식일 땐 query로 받는다.
    let name = req.query.name;
    console.log("number: " +number);
    console.log("name: " +name);

    res.send("성공!");
})

// 5. post
// POST 방식으로 /conn_param 경로에 요청을 처리
app.post("/conn_post_param", (req, res) => {
    console.log("/conn_post_param 접속");

    // POST 방식일 때는 body에서 데이터를 받습니다.
    let number = req.body.number;
    let name = req.body.name;
    console.log("number: " + number);
    console.log("name: " + name);

    res.send("success!");
});

module.exports = app;