<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>도시 정보 입력</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 500px;
            padding: 20px;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
            margin-top: 10px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>도시 정보 입력</h1>
    <form action="cityInsert" method="post">
        <label for="name">도시 이름:</label>
        <input type="text" id="name" name="name" />

        <label for="countryCode">국가 코드:</label>
        <input type="text" id="countryCode" name="countryCode" />

        <label for="district">지역:</label>
        <input type="text" id="district" name="district" />

        <label for="population">인구:</label>
        <input type="number" id="population" name="population" />

        <input type="submit" value="삽입" />
    </form>

    <hr color="red">
    <a href="cityList">City 전체 목록 검색 </a>
</div>
</body>
</html>
