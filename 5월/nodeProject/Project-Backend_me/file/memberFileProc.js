const fs = require('fs');

let memberCrud = {};

memberCrud.idcheck = function(id){
    // 파일로부터 데이터 불러오기
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

memberCrud.regi = function(id, pw, name, email){
    let str = fs.readFileSync(__dirname + "/member.json", "utf-8");

    let member = [];
    if(str !== undefined && str !== ''){
        member = JSON.parse(str);
    }

    let addMember = { "id":id, "pw":pw, "name":name, "email":email };
    member.push(addMember);

    fs.writeFileSync(__dirname + "/member.json", JSON.stringify(member, null, 1));

    return "YES";
}

memberCrud.login = (id, pw) => {
    let str = fs.readFileSync(__dirname + "/member.json", "utf-8");

    let member = [];
    if(str !== undefined && str !== ''){
        member = JSON.parse(str);
    }

    let index = -1;
    member.forEach((mem, i)=>{
        if(id === mem.id && pw === mem.pw){
            index = i;
            return;
        }
    })

    console.log(index);
    if(index < 0){
        return '';
    }else{
        return member[index];
    }
}



module.exports = memberCrud;