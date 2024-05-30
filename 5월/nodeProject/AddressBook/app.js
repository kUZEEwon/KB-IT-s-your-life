

const express = require('express');
const app = express();

const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false}));

const member = require('./routes/member');
app.use(member);

// server
app.listen(3000, () => {
    console.log("backend server start port : 3000...");
})