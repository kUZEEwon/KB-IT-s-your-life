// 주소록 검색 웹 제작

const fs = require('fs');

let memberDao = {};

// insert
memberDao.insert = function (name, age, phone, address, memo) {
    let str = fs.readFileSync(__dirname + "/member.json", 'utf-8');

    let member = [];
    if (str !== undefined && str !== '') {
        member = JSON.parse(str);
    }
    let addmember = { "name": name, "age": age, "phone": phone, "address": address, "memo": memo };
    member.push(addmember);

    fs.writeFileSync(__dirname + "/member.json", JSON.stringify(member, null, 1));

    return "추가 완료";
}

memberDao.remove = function (name) {
    let str = fs.readFileSync(__dirname + "/member.json", 'utf-8');

    // json 불러오기
    let member = []; // 'member'로 수정
    if (str !== undefined && str !== '') {
        member = JSON.parse(str);
    }

    // 같은 이름을 가진 객체를 찾아 삭제(강사님)
    // 1) 이름이 있는지?
    let findIndex = -1;
    member.forEach((mem, index) => {
        if (name === mem.name) {
            findIndex = index;
        }
    });

    // 2) 같은 이름을 찾았다면 삭제함
    if (findIndex !== -1) {
        member.splice(findIndex, 1); // findIndex부터 1개의 객체만 삭제하라
        fs.writeFileSync(__dirname + "/member.json", JSON.stringify(member, null, 1)); // 'members'가 아니라 'member'를 사용
    }

    return findIndex;
}



// select
memberDao.select = function (name) {
    let str = fs.readFileSync(__dirname + "/member.json", "utf-8");

    let member = [];
    if (str !== undefined && str !== '') {
        member = JSON.parse(str);
    }

    // 1.
/*  let selectMember = [];
    member.forEach((mem)=>{
        if(name === mem.name){
            selectMember.push(mem);
        }
    })*/

    // 2.
    const selectMember = member.filter((mem)=>{
        return name === mem.name;
    })

    return selectMember;
}

// update
memberDao.update = function (name, newData) {
    let str = fs.readFileSync(__dirname + "/member.json", 'utf-8');

    // JSON 데이터 파싱
    let members = [];
    if (str !== undefined && str !== '') {
        members = JSON.parse(str);
    }

    // 같은 이름을 가진 객체를 찾아 업데이트
    /* 
    . spread 연산자(...)를 사용하여 두 객체를 병합할 때, 
    동일한 속성이 있을 경우에는 마지막 객체에서의 값이 사용됩니다. 
    따라서 newData 객체의 속성이 member 객체의 동일한 속성을 덮어씁니다.
    */
    let updated = false;
    members.forEach((member, index) => {
        if (name === member.name) {
            members[index] = { ...member, ...newData }; // 새로운 데이터로 업데이트
            updated = true;
        }
    });

    // 업데이트된 데이터를 파일에 쓰기
    if (updated) {
        fs.writeFileSync(__dirname + "/member.json", JSON.stringify(members, null, 1)); 
    }

    return updated;
};

module.exports = memberDao;