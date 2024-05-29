
const fs = require('fs');

let str = fs.readFileSync("./member.json","utf-8")
console.log(str);

console.log(str[0].name); // undefined (json이 아니라 문자열 형식이라 인식 안됨)

let json = JSON.parse(str);
// 내용 출력 하기

/* console.log(json[0].name);
console.log(json.length);
console.log(json); */


/* json.forEach(item => {
    console.log(item.id);
    console.log(item.pw);
    console.log(item.name);
    console.log(item.email);
}); */


// map 을 이용해서 출력하기
/* json.map((item, i) => {
    // i: index number
    console.log(i);
    console.log(item.id);
    console.log(item.pw);
    console.log(item.name);
    console.log(item.email);
}) */

// 추가 
let addJson = { id:"abcccd", pw:"8594", name:"쿠로미", email:"abcccd@email.com" };
json.push(addJson);
console.log(json);

// 삭제
json.splice(0, 1); // (몇번째 데이터 부터, 몇번째 까지 삭제), 0번째 부터 1개 
console.log("삭제 후\n",json);

// 수정
json[0].id = "abds";
json[0].name = "구지영";
console.log("수정 후\n",json);

// 파일로 저장(문자열로 저장해야 들어간다)
fs.writeFileSync("./member.json", JSON.stringify(json, null, 1));
