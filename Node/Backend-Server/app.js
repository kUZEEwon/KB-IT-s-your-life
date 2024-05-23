
const express = require(`express`);
const app = express();

let member = [
    { id:"abc", name:'홍길동', age:24 },
    { id:"def", name:'랩몬스터', age:30 },
    { id:"zue", name:'전정국', age:29 }
]

const server = app.listen(3000, () => {
    console.log(`server start port: 3000`);
});

app.get('/', (req, res) => {
    res.send('Hello');
});

app.get(`/test`, (req, res) => {
    // console.log(req.query.id);

    res.send(`안녕하세요`);
});

app.get(`/check`, (req, res) => {
    // query의 id가 member에 있다면 해당 행을 send
    const memberId = req.query.id;
    const foundMember = member.find(member => member.id === memberId);
    if (foundMember) {
        res.send(foundMember);
    } else {
        res.send('Member not found');
    }
});
