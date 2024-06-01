const cors = require('cors');
const express = require('express');

const app = express.Router();

app.use(cors());

const memberDao = require('../json/memberProc');

app.use(cors({ origin:"*"})); // 누구나 전부 접속 가능함

app.post("/memberAdd", function(req,res){
    console.log("memberAdd 접속 성공");

    let name = req.body.name;
    let age = req.body.age;
    let phone = req.body.phone;
    let address = req.body.address;
    let memo = req.body.memo;

    console.log(req.body);
    //console.log(name, age, phone, address, memo);
    
    let result = memberDao.insert(name, age, phone, address, memo);
    console.log(result);

    res.send({"result":result});  


});

app.post("/memberRemove", function(req,res){
    console.log("memberRemove 접속 성공");

    let name = req.body.name;

    //console.log(req.body);
    console.log(name);
    
    let result = memberDao.remove(name);
    console.log(result);

    res.send({"result":result});  

});

app.post("/memberSelect", function(req, res) {
    console.log("memberSelect 접속 성공");

    let name = req.body.name;

    console.log(req.body);

    let selectedMember = memberDao.select(name);
    console.log("Selected member:", selectedMember);

    res.send({ "result": selectedMember });
});


module.exports = app;