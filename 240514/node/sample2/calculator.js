
/* const plus = function(a,b){
    return a+b;
}

exports.plus = plus; // 외부 모듈로 추출 */


let mymodule = {};

mymodule.add = function (arg1, arg2) {
    return arg1 + arg2;
}

mymodule.multi = function (arg1, arg2) {
    return arg1 * arg2;
}

mymodule.name = "mymelody";
mymodule.height = 129.3;

exports.mymodule = mymodule;