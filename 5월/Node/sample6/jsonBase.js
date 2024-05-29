
let json = {name:"John", age:30, gender:"male"};

// add item
json.birthday = "2000-09-18";
console.log(json);

// delete
delete json.gender;
console.log(json);


// json에 object를 추가, 삭제, 수정
let jsonArr = [{ "number" : 2, "color" : "red", }];
console.log(jsonArr.length);

// 추가
let addJson = { "number":3, "color":"blue" };
jsonArr.push(addJson);

console.log(jsonArr);

// 수정
jsonArr[0].number = 1;
jsonArr[0].color = "yellow";
console.log(jsonArr);

// 삭제 
jsonArr.splice(0, 1); // (몇번째 데이터 부터, 몇번째 까지 삭제), 0번째 부터 1개 
console.log(jsonArr);