
const fs = require('fs');
const readline = require('readline');

// 보고 싶은 영화를 입력받는 함수
const promptMovieInput = () => {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    rl.question("보고 싶은 영화 입력 >> ", (movie) => {
        saveMovieToFile(movie);
        rl.close();
    });
}

// 입력한 데이터를 파일에 저장하는 함수
const saveMovieToFile = (movie) => {

    const filePath = './movie.txt';   // jsoup


    // 파일이 존재하지 않으면 생성해서 저장함
    if (!fs.existsSync(filePath)) {
        fs.writeFileSync(filePath, movie);
        console.log(`${movie} 영화를 저장했어요.`);
    } else {
        console.log(`${filePath} :   파일이 이미 존재합니다.\n`);
    }
}

promptMovieInput();