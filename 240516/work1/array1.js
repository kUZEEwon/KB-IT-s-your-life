// 새로운 인터페이스 생성
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// 사용자 입력
rl.question('이름을 입력하세요 >> ', (name) => {
    console.log(`안녕하세요, ${name}님!`);
    rl.close();
});


