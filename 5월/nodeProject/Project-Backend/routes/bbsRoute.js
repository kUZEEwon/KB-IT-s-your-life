const cors = require('cors');
const express = require('express');

const app = express.Router();

app.use(cors());

const bbsCrud = require("../file/bbsFileProc.js");

app.get("/bbslist", function(req, res){
    console.log("/bbslist 접속");

    const search = req.query.search;    // 검색어
    const choice = req.query.choice;    // 카테고리

    const bbslist = bbsCrud.bbslist(search, choice);

    res.send(bbslist);
})

app.get("/bbswrite", function(req, res){
    console.log("/bbswrite 접속");

    const id = req.query.id;
    const title = req.query.title;
    const content = req.query.content;

    bbsCrud.bbswrite(id, title, content);

    res.send("OK");
})

app.get("/bbsdetail", function(req, res){
    console.log("/bbsdetail"); 

    var seq = req.query.seq;
    console.log("seq:" + seq);    
    
    let bbs = bbsCrud.bbsdetail(seq);
    console.log(bbs);
    res.send(bbs);
})

module.exports = app;