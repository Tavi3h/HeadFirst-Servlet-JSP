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
		<c:forEach var="listElement" items="${requestScope.movieList}">
			<c:forEach var="movie" items="${listElement}">
				<tr>
					<td>${movie}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
</body>
</html>