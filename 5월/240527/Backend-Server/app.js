
const express = require("express");
const app = express();

// parameter를 받기 위한 모듈
const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:false}));

// Router
const memberR = require("./routes/memberRouter");
app.use(memberR);


app.listen(3000, ()=>{
    console.log("server start port:3000");
});