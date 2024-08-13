<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>jQuery Example</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
        $(() => { //document.ready()와 동일
            $('#data').click(function(){
                axios.get("data")
                    .then(function(response) {
                        const data = response.data;
                        $('#result1').append(data)
                    })
                    .catch(function(error) {
                        console.error('Error fetching data:', error);
                    });
            });

            $('#food').click(function(){
                    axios.get("food")
                        .then(function(response) {
                            const data = response.data;
                            $('#result2').append(data)
                        })
                        .catch(function(error) {
                            console.error('Error fetching data:', error);
                        });
            });

            $('#weather').click(function(){
                axios.get("weather")
                    .then(function(response) {
                        const data = response.data;
                        $('#result3').append(data)
                    })
                    .catch(function(error) {
                        console.error('Error fetching data:', error);
                    });
            });
        });
    </script>
</head>
<body>
<h1>Original Text</h1>
<button id="data">공공 데이터 포탈 데이터 요청</button>
<button id="food">주변 맛집 정보 요청</button>
<button id="weather">기상청 정보 요청</button>
<p id="result1" style="background: lemonchiffon"></p>
<p id="result2" style="background: yellow"></p>
<p id="result3" style="background: lime"></p>
</body>
</html>
