<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>

<button type="button" onclick="buttonClick()">클릭</button>

<p id="domo"></p>

<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    // 비동기식
    async function buttonClick()
    {
        //let str = "Nice to meet you!";
        let str =  [{ "id" : "abc", "pw" : "123"},
            { "id" : "seb", "pw" : "468"},
            { "id" : "bfe", "pw" : "259"}];

       // await axios.get('world', {params : { str : str }}) // 컨트롤러로 보내는 데이터
       // await axios.post('world', null, { params: { str: JSON.stringify(str)}}) // post는 null붙이기
        await axios.get('world', { params: { str: JSON.stringify(str)}}
            .then(function (resp) {
                document.getElementById("domo").innerText = resp.data;
            })
            .catch(function (err) {
                console.log(err);
            })
        )
    }
</script>
</body>
</html>
