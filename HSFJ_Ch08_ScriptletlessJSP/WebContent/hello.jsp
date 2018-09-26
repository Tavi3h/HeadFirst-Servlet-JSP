<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	Welcome to our page!
	<%
	if (request.getParameter("userName") == null) {
	%>
	<jsp:forward page="handleit.jsp"></jsp:forward>
	<%
		}
	%>
	Hello ${param.userName}
</body>
</html>