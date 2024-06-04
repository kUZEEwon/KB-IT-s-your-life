
const express = require('express');
const app = express();

const test = require('./routes/test.js');
app.use(test);

// server
app.listen(3000, () => {
    console.log("backend server start port : 3000...");
})