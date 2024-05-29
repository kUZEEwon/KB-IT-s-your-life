/* 
    URL :   Uniform Resource Locator
            획일적인            위치탐사
*/

let url = require('url');      // npm install url

let addr = 'http://localhost:3000/default.html?year=2023&month=february';
let qu = url.parse(addr, true);     // json 형식으로

console.log('start');
console.log(qu);

console.log(qu.host);
console.log(qu.pathname);
console.log(qu.search);

let pdata = qu.query;
console.log(pdata);
console.log(pdata.month);