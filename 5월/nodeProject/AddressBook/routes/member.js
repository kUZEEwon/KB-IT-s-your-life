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
    
    const result = memberDao.remove(name);
    console.log(result);

    res.send({"result":result});  

});

app.post("/memberSelect", (req, res)=> {
    console.log("memberSelect 접속 성공");

    let name = req.body.name;

    console.log(req.body);

    const selectedMember = memberDao.select(name);
    console.log("Selected member:", selectedMember);

    res.send({ "result": selectedMember });
});

app.post('/updateMember', (req, res) => {
    const { name, newData } = req.body;
    const updated = memberDao.update(name, newData);
    if (updated) {
        res.send('Member updated successfully');
    } else {
        res.status(404).send('Member not found');
    }
});


module.exports = app;