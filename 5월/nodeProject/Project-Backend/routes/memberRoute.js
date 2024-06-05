const cors = require("cors");
const express = require("express");

const app = express.Router();

app.use(cors());

const memberCrud = require("../file/memberFileProc");

app.post("/idcheck", (req,res) => {
    console.log("/idcheck 접속");

    const id = req.body.id;
    console.log('id : '+id);

    const result = memberCrud.idcheck(id);
    if(result === 0){
        res.send({ result:'YES' });
    }else{
        res.send({ result:'NO' });
    }

})

module.exports =app;