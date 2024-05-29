const p = new Promise((resolve, reject) => {
    console.log('Promise를 시작합니다');
    resolve('두수를 랜덤하게 생성하여 더한 후 리턴');
});

p.then((msg) => {
    console.log(`1 ==> ${msg}`);

    const num1 = Math.floor(Math.random() * 10) + 1;
    // console.log(`num1 ==> ${num1}`);
    const num2 = Math.floor(Math.random() * 10) + 1;
    // console.log(`num2 ==> ${num2}`);

    const sum = num1 + num2;
    return sum;
})
.then((msg) => {
    console.log(`2 ==> ${msg}`);
    console.log("두 수를 랜덤하게 생성하여 곱한 값을 리턴");
    const num1 = Math.floor(Math.random() * 10) + 1;
    const num2 = Math.floor(Math.random() * 10) + 1;

    const mul = num1 * num2;
    return `${msg},${mul}`;
})
.then((msg) => {
    console.log(`2 ==> ${msg}`);
    let arr = msg.split(",");   // , -> token
    console.log(`두수의 합은 ${arr[0]}\n두수의 곱은 ${arr[1]}`);
})
.catch((error) => {
    console.log(`오류발생 ==> ${error}`);
});


