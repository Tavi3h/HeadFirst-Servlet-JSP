<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beer Selection Page</title>
</head>
<body>
	<h1 align="center">Beer Seletion Page</h1>
	<form action="SelectBeer.do">
		<p>Select beer characteristics</p>
		<select name="color" size="1">
			<option value="light">light</option>
			<option value="amber">amber</option>
			<option value="brown">brown</option>
			<option value="dark">dark</option>
		</select>
		<br>
		<br>
		<input type="submit">
	</form>
</body>
</html>