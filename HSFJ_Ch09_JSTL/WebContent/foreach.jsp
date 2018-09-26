<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie List</title>
</head>
<body>
	<table>
		<c:forEach var="movie" items="${requestScope.movieList}" varStatus="movieLoopCount">
			<tr>
				<td>Count: ${movieLoopCount.count}</td>
			</tr>
			<tr>
				<td>${movie}</td>
			</tr>
		</c:forEach>
	</table>
</body> 
</html>