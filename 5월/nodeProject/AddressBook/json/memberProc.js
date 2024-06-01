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
    // age를 숫자로 변환하고 유효성 검사를 수행
    age = Number(age);

    let addmember = {"name":name, "age":age, "phone":phone, "address":address, "memo":memo};
    member.push(addmember);

    fs.writeFileSync(__dirname+"/member.json", JSON.stringify(member, null, 1));

    return "추가 완료";
}

// delete
memberDao.remove = function(name) {
    let str = fs.readFileSync(__dirname + "/member.json", 'utf-8');

    let members = [];
    if (str !== undefined && str !== '') {
        members = JSON.parse(str);
    }

    // 같은 이름을 가진 객체를 찾아 삭제
    for (let i = 0; i < members.length; i++) {
        if (members[i].name === name) {
            members.splice(i, 1); // 해당 객체 삭제
            i--; // 배열이 한 칸씩 당겨지므로 인덱스 조정
        }
    }

    fs.writeFileSync(__dirname + "/member.json", JSON.stringify(members, null, 1));

    return "삭제 완료";
}

// select
memberDao.select = function(name) {
    let str = fs.readFileSync(__dirname + "/member.json", 'utf-8');

    let members = [];
    if (str !== undefined && str !== '') {
        members = JSON.parse(str);
    }

    // 주어진 이름과 일치하는 객체를 찾아 반환
    let selectedMember = members.find(member => member.name === name);

    return selectedMember; // 찾은 멤버 객체를 반환, 없으면 undefined 반환
}

// update
memberDao.update = function(name){

}

module.exports = memberDao;