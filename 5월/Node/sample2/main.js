
// 외부 모듈 불러오기

const calculator = require('./calculator');

/* let result = plus.plus(12,34);

console.log(result); */

console.log(calculator.mymodule.name);
console.log(calculator.mymodule.height);

let mResult = calculator.mymodule.multi(3,4);
console.log(mResult);

