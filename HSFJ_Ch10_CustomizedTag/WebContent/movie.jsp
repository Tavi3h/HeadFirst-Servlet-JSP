<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="myTags" uri="simpleTags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie List</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Movie Name</td>
			<td>Movie Genre</td>
		</tr>
		<myTags:simple5 movieList="${requestScope.movieCollection}">
			<tr>
				<td>${movie.name}</td>
				<td>${movie.genre}</td>
			</tr>
		</myTags:simple5>
	</table>
</body>
</html>