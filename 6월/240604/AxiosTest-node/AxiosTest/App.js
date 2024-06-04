const express = require("express");
const app = express();

const test = require('./routes/test.js');

app.use(test);

app.listen(3000, function(){
    console.log("web server start port:3000");
});

