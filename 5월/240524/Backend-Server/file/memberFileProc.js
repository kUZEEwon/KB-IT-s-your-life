
const fs = require("fs");

let memberCrud = {};    // Create, Read, Update, Delete

// id check
memberCrud.idcheck = function(id){
    let str = fs.readFileSync(__dirname + "/member.json", "utf-8");

    let member = [];
    if(str !== undefined && str !== ''){
        member = JSON.parse(str);
    }

    let result = 0;
    member.forEach(mem => {
        if(mem.id === id){
            result = 1;
        }
    });

    return result;
}

// 회원가입
memberCrud.regi = function(id, pw, name, email){

}

// id & pw 확인 -> login
memberCrud.login = function(id, pw){

}

module.exports = memberCrud;




