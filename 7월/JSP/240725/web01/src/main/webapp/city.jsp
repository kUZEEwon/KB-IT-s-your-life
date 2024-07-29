<%--
  Created by IntelliJ IDEA.
  User: koo
  Date: 24. 7. 25.
  Time: 오후 4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>City Form</title>
</head>
<body>
<h1>Enter City Infromation</h1>
<br/><br/>
<a href="tour?cityName=busan&cityPopulation=5000">busan</a>
<hr color="red"/>
<hr color="red">
<form action="tour" method="post">
    <label for="cityName">City Name:</label>
    <input type="text" id="cityName" name="cityName" required><br><br>
    <label for="cityPopulation">City Population:</label>
    <input type="text" id="cityPopulation" name="cityPopulation" required><br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
