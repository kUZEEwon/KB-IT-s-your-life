const fs = require('fs');

let bbsCrud = {};

bbsCrud.bbslist = function(search, choice){
    // 파일로부터 데이터 불러오기
    let str = fs.readFileSync(__dirname + "/bbs.json", "utf-8");

    let bbslist = [];
    if(str !== undefined && str !== ''){
        bbslist = JSON.parse(str);
    }

    console.log(search, choice);

    // 검색용
    let resultList = [];
    bbslist.forEach(bbs => {        
        if(choice !== undefined && choice !== '' 
            && search !== undefined && search !== ''){        
            if(choice === 'title'){ // 나는 가능성이 높다
                let n = bbs.title.indexOf(search);
                if(n !== -1){
                    resultList.push(bbs);
                }
            }else if(choice === 'content'){
                let n = bbs.content.indexOf(search);
                if(n !== -1){
                    resultList.push(bbs);
                }
            }else if(choice === 'writer'){
                if(bbs.id === search){
                    resultList.push(bbs);
                }
            }
        }else{
            resultList.push(bbs);
        }
    });

    return resultList;
}

bbsCrud.bbswrite = function(id, title, content){
    // 파일로부터 데이터 불러오기
    let str = fs.readFileSync(__dirname + "/bbs.json", "utf-8");

    let bbslist = [];
    if(str !== undefined && str !== ''){
        bbslist = JSON.parse(str);
    }

    const seq = bbslist[bbslist.length - 1].seq + 1;

    const date = new Date();

    const currentDate = date.getFullYear() + "-"        
                        + two((date.getMonth() + 1) + "") + "-"      // 6 -> 06
                        + two(date.getDate() + "");
    console.log(currentDate);
    const bbs = {
        "seq":seq,
        "id":id,
        "title":title,
        "content":content,
        "wdate":currentDate,
        "readcount":0
    };
    bbslist.push(bbs);

    fs.writeFileSync(__dirname + "/bbs.json", JSON.stringify(bbslist, null, 1));
}

bbsCrud.bbsdetail = function(seq){
    let str = fs.readFileSync(__dirname + "/bbs.json", "utf-8");

    let bbslist = [];
    if(str !== undefined && str !== ''){
        bbslist = JSON.parse(str);
    }

    let index = -1;
    bbslist.map((bbs, i)=>{        
        if(bbs.seq == seq){
            index = i;     
            return;       
        }
    })
    
    console.log("index:" + index);
    return bbslist[index];
}

function two(str){     // 1 -> 01
    return str.length<2?"0"+str:str;
}

module.exports = bbsCrud;