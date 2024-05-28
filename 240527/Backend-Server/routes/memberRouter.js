
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

app.post("/regi", (req, res)=>{
    console.log('regi 접속 성공!');

    let id = req.body.id;       // post === body    get === query
    let pw = req.body.pw;
    let name = req.body.name;
    let email = req.body.email;
    console.log("id = " + id);
    console.log("email = " + email);

    let result = memberCrud.regi(id, pw, name, email);
    if(result === 1){
        res.send("OK");
    }else{
        res.send("NO");
    }
})

app.post("/login", function(req, res){

});

module.exports = app;

