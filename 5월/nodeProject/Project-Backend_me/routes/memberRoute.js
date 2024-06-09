const cors = require('cors');
const express = require('express');

const app = express.Router();

app.use(cors());

const memberCrud = require("../file/memberFileProc.js");

app.post("/idcheck", function(req, res){
    console.log("/idcheck 접속");

    // const id = req.body.id;
    console.log('req.body.id:' + req.body.id);

    const result = memberCrud.idcheck(req.body.id);
    if(result === 0){
        res.send({ result:'YES' });        
    }else{
        res.send({ result:'NO' });        
    }
})

app.post("/regi", (req, res)=>{
    console.log("/regi 접속");

    const id = req.body.id;
    const pw = req.body.pw;
    const name = req.body.name;
    const email = req.body.email;

    let result = memberCrud.regi(id, pw, name, email);
    
    res.send({ "result":result });    
})

app.post("/login", function(req, res){
    console.log("/login 접속");

    const id = req.body.id;
    const pw = req.body.pw;

    console.log("id: " + id);
    console.log("pw: " + pw);

    let result = memberCrud.login(id, pw);
    console.log(result);
    res.send(result);
})


module.exports = app;