const fs = require("fs");

let memberCrud = {};

memberCrud.idcheck = function(id){
    // file로부터 데이터를 불러오기
    let str = fs.readFileSync(__dirname + "/member.json", 'utf-8');

    let member = [];
    if (str !== undefined && str !== '') {
        member = JSON.parse(str);
    }

    let result = 0;
    member.forEach(mem => {
        if (mem.id === id) {
            result = 1;
        }
    });

    return result;
    
}





module.exports = memberCrud;