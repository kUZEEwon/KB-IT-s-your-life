/*
const plus = function(a, b){
    return a + b;
}

exports.plus = plus;
*/


let mymodule = {};

mymodule.add = function(arg1, arg2){
    return arg1 + arg2;
}
mymodule.multi = function(arg1, arg2){
    return arg1 * arg2;
}

mymodule.name = "이몽룡";
mymodule.height = 172.3;

exports.mymodule = mymodule;






