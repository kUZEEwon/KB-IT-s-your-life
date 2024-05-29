let name = "John";

console.log("Hello " + name);
console.log(`Hello ${name}`);

function addContact(
  name,
  mobile,
  home = "있음",
  address = "없음",
  email = "있음",
  ...favoritesFoods
) {
  console.log("name >> " + name);
  console.log("home >> " + home);
  console.log("address >> " + address);
  console.log("email >> " + email);
  console.log("favoritesFoods >> " + favoritesFoods);
}

addContact("홍길동", "123-3456");
addContact(
  "성춘향",
  "933-5496",
  "my home",
  "서울시",
  "bac@jiwon.net",
  "pizza",
  "햄버거"
);

let name2, tel, addr, age1;

function addContact2(name, phone, email = "이메일", age = 14) {
  name2 = name;
  tel = phone;
  addr = email;
  age1 = age + 10;

  return { name2, tel, addr, age1 };
}

let { name2: n, tel: t, addr: a, age1: ag } = addContact2(
  "마이멜로디",
  "324-3495",
  "mymelody@kitty.net"
);
console.log(n, t, a, ag);

// es6
/* function funcOne(params){
  console.log()
} */

/* const funcOne = function(params) {
  console.log(params+ "님 환영합니다.");
} */

const funcOne = (params) => {
  console.log(params + "님 환영합니다.");
}

funcOne('이몽룡');

const test1 = (a, b) => a + b; // return 안해도 된다.

function test1(a, b) {
  return a + b;
}

let result = test1(1, 2);
console.log(result);

