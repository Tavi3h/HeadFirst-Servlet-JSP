<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result Page</title>
</head>
<body>
	<h1 align="center">Beer Recommendations JSP</h1>
	<p>
		<c:forEach var="style" items="${requestScope.styles}">
           try: ${style} <br>
        </c:forEach>
	</p>
</body>
</html>