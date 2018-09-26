<%@page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<strong>Bummer.</strong>
	<br>
	You caused a ${pageContext.exception} on the server
	<br>
	<img alt="bummer" src="images/bummer.jpg">
</body>
</html>