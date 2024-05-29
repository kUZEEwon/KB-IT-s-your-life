/* 
● 입력 : 맑음,흐림,흐림,보통,보통,흐림
● 출력 :
    ○ 전체 출력 : 맑음, 흐림, 흐림, 보통, 보통,
    흐림
    ○ 개수 출력 : 맑은- 1, 흐림- 3, 보통- 2
*/

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question("일주일간 날씨를 입력하세요 >> ", (data) => {

    console.log(`전체 날씨 출력 >> ${data}`);

    let arr_data = data.split(",");
    console.log(arr_data);

    let count_map = new Map();
    // Map 은 키와 값   key : value

    for (let one of arr_data) {
        console.log("one >> ", one);
        // key 값(맑음, 흐림, 보통)을 가지고 있는가?
        // value는 배열 안의 key값의 개수
        console.log("has(key) >> ",count_map.has(one)); 

        // key 값 개수 세기
        if(count_map.has(one)){
            count_map.set(one, count_map.get(one) + 1);
        }else{
            count_map.set(one, 1);
        }
    }
    
    for(const key of count_map.keys()){
        console.log(`${key} - ${count_map.get(key)}`);
    }
    rl.close();
})
