<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>risky</title>
</head>
<body>
	About to do a risky thing：
	<br>
	<c:catch var="myException">
		<%
			int x = 10 / 0;
		%>
	</c:catch>
	<c:if test="${myException != null}">
		There was an exception：${myException.message}<br>
	</c:if>
	If you see this, we survived.
</body>
</html>