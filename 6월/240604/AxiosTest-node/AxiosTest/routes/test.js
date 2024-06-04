const express = require('express');
const cors = require('cors');

const app = express.Router();
app.use(cors());

// parameter 를 받기 위해서 설정
const bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended:false }));

// 1.
app.get("/", function(req, res){
    console.log("/ 접속");

    res.send("안녕하세요");
});

// 2.
app.get("/test", function(req, res){
    console.log("/test 접속");

    res.send({ "test":"OK" });
});

// 3.
app.get("/human", function(req, res){
    console.log("/human 접속");

    let human = { id:"abc", "name":"홍길동", "height":172.1 };

    res.send(human);
});

// 4.
app.get("/conn_param", (req, res)=>{
    console.log("/conn_param 접속");

    let number = req.query.number;  // <- get
    let name = req.query.name;

    console.log("number: " + number);
    console.log("name: " + name);

    res.send("성공!");
})

// 5. post
app.post("/conn_post_param", (req, res)=>{
    console.log("/conn_post_param 접속");

    let number = req.body.number;  // <- post
    let name = req.body.name;

    console.log("number: " + number);
    console.log("name: " + name);

    res.send("success!!");
})



module.exports = app;



