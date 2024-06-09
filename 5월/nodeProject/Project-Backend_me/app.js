const express = require('express');

const app = express();

const member = require('./routes/memberRoute.js');
const bbs = require('./routes/bbsRoute.js');

const bodParser = require('body-parser');
app.use(bodParser.json());
app.use(bodParser.urlencoded({extended:false}));

app.use(member);
app.use(bbs);

app.listen(3000, function(){
    console.log("web server start port:3000");
})
