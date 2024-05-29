
const cors = require('cors');   // npm i cors

const express = require("express");
const app = express.Router();

const memberCrud = require("../file/memberFileProc");

app.use(cors({
    origin:'*'
}));

app.post("/idcheck", function(req, res){
    console.log("idcheck 접속성공!");    
    let id = req.body.id;
    console.log("id = " + id);

    let result = memberCrud.idcheck(id);
    if(result === 0){
        res.send({ result:"OK" });
    }else{
        res.send({ result:"NO" });  // id 있음
    }
});

module.exports = app;

