<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="last" value="Hidden Cursor" />
	<c:set var="first" value="Crouching Pixels" />
	<c:url value="/inputcomments.jsp" var="inputurl">
		<c:param name="firstName" value="${first}" />
		<c:param name="lastName" value="${last}" />
	</c:url>
	The URL using params is ${inputurl}


</body>
</html>