// user.js hello.js 불러오기
const users = require("./user");
const hello = require("./hello");

console.log(users);
hello(users.user3);

// user2.js 불러오기
const person = require("./user2");

console.log(person);
console.log('name >> ', person.name);
console.log('age >> ', person.age);
console.log('tel >> ', person.tel);