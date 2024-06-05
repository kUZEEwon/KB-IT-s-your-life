const cors = require("cors");
const express = require("express");

const app = express.Router();

app.use(cors);

const memberCrud = require("../file/memberFileProc");

app.post("/idcheck", (req,res) => {

})

module.exports =app;