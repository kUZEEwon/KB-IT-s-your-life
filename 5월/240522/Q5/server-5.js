/* callback 함수를 사용해 비동기 처리하기

const fs = require('fs');

let files = fs.readdir("./", (err,files) => {
    if(err){
        console.error(err);
    }
    console.log(files);
});
console.log("Code is done");

다음과 같이 readdir을 모두 완료하기 전에 아래의 코드가 실행되었다.
async(비동기)/await 를 사용해서 readdir 후에 아래 코드가 실행되도록 수정해라. */

// async/await : 현재 작업이 끝나기 전에 다른 작업을 시행하고 싶지 않을 때 (무조건 작업이 끝난 후 다른 작업 수행)
// async, await을 통해서 처리가 끝날 때 까지 기다림

const fs = require('fs').promises;

/*
fs.readdir('./')            // === fetch    === axios
    .then((result) => console.log(result))
    .then((result) => console.log("Code is done"))
    .catch((err) => console.log(err));
*/

async function readDirectory() {
    try {
        const result = await fs.readdir('./'); 
        console.log(result);
        console.log("Code is done");
    }catch(err){
        console.log(err);
    }
}

readDirectory();