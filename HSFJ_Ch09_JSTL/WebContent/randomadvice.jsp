<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="mine" uri="randomThings"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Random Advice</title>
</head>
<body>
	Advice Page. ${mine:rollIt()} 
	<br>
	<c:set var="userName" value="Tavish" />
	<mine:advice user="${userName}" />
</body> 
</html>