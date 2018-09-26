<%@page errorPage="errorpage.jsp" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	About to be bad ...
	<%-- 使用数学计算引发异常 --%>
	<%
		int x = 10 / 0;
	%>
</body>
</html>