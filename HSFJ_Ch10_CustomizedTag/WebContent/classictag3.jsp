<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="mine" uri="KathyClassicTags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Classic Tag</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Movie</td>
		</tr>
		<mine:iteratorMovies>
			<tr>
				<td>${movie}</td>
			</tr>
		</mine:iteratorMovies>
	</table>
	
</body>
</html>