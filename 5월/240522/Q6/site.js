const http = require('http');
const fs = require('fs');
/*
const server = http.createServer((req, res)=>{

    const {method, url} = req;

    if(method === "GET" && url === '/'){
        res.statusCode = 200;
        const readStream = fs.createReadStream(__dirname + "/home.html", "utf-8");
        readStream.pipe(res);
    }
});

server.listen(3000, ()=>{
    console.log('server start port:3000');
});
*/

http.createServer(function(req, res){

    fs.readFile(__dirname + "/home.html", function(err, data){
        if(err) console.log(err);

        console.log('readFile success');
        console.log(__dirname);

        if(req.method === 'GET'){

            res.writeHead(200, {'Content-Type':'text/html'});

            console.log("" + data);

            res.write(data);
            res.end();
        }
        else{   // POST

        }

    })

}).listen(3000);
