// 주소록 검색 웹 제작

const fs = require('fs');

let memberDao ={};

// insert
memberDao.insert = function(name, age, phone, address, memo)
{
    let str = fs.readFileSync(__dirname + "/member.json", 'utf-8');

    let member = [];
    if(str !== undefined && str !== ''){
        member = JSON.parse(str);
    }

    let addmember = {"name":name, "age":age, "phone":phone, address:"address", memo:"memo"};
    member.push(addmember);

    fs.writeFileSync(__dirname+"/member.json", JSON.stringify(member, null, 1));

    return "추가 완료";
}

// delete
memberDao.delete = function(name){

}

// select
memberDao.select= function(name){

}

// update
memberDao.update = function(name){

}

module.exports = memberDao;