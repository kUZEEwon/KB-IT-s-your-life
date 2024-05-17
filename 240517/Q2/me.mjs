// const fs = require()
import fs from 'fs';

// ES 모듈 내에 __dirname 정의하기
import path from 'path';
import { fileURLToPath } from 'url';
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

// 파일 경로
const filePath = __dirname + "/me.txt";
// console.log(filePath);

try {
    // me.txt 의 내용을 동기적으로 읽기
    const fileContent = fs.readFileSync(filePath, "utf-8");
    // console.log(fileContent);
} catch (err) {
    console.log('파일 오류 ', err);
}

// 읽어올 파일 경로
const readFilePath = './me.txt';

// 쓰기 파일의 경로
const writeFilePath = './you.txt';

// 추가할 내용
const addContent = `\n
************************
나는 별이야
제일 빛나
************************\n`;

// me.txt 파일의 존재 여부 체크
const fileExists = fs.existsSync(readFilePath);
// console.log(fileExists);

if (fileExists) {
    try {
        const fileContent = fs.readFileSync(readFilePath, "utf-8");
        console.log(fileContent);

        // 새로운 파일에 쓰기 -> 만약에 파일이 없으면 새로 생성 + 쓰기
        fs.writeFileSync(writeFilePath, fileContent);
        console.log(`파일 ${writeFilePath}에 저장 완료!`);

        // 추가 쓰기
        fs.appendFileSync(writeFilePath, addContent, 'utf-8');
        console.log('새로운 파일에 추가 저장 완료\n');

        // 'you.txt'에 업데이트 된 내용 읽고 출력하기
        const newFileContent = fs.readFileSync(writeFilePath, 'utf-8');
        console.log(newFileContent);
    } catch (err) {
        console.log("파일 오류 발생");
    }

} else {
    console.log('읽을 파일이 존재하지 않습니다.');
}
