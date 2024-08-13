<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>jQuery Example</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(() => { //document.ready()와 동일
            $('#changeText').click(function(){
                $('h1').text('Hello, jQuery!');
                $('result1').html('<h1>Hello, jQuery!</h1>');
            });

            $('#hideParagraph').click(function(){
                $('#result2').html('<h1>데이터를 숨겼음</h1>');
                $('p').hide();
            });

            $('#showParagraph').click(function(){
                $('#result2').html('<h1>데이터를 보이게</h1>')
                $('p').show();
            });
        });
    </script>
</head>
<body>
<h1>Original Text</h1>
<button id="changeText">Change Text</button>
<button id="hideParagraph">Hide Paragraph</button>
<button id="showParagraph">Show Paragraph</button>
<p style="background: red; color: white;">This is a paragraph.</p>
<div id="result1" style="background: yellow"></div>
<div id="result2" style="background: pink"></div>
</body>
</html>
