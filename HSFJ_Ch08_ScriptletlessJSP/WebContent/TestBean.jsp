<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
	<jsp:useBean id="person" type="foo.Employee" class="foo.Employee">
		<jsp:setProperty name="person" property="*" />
	</jsp:useBean>
	Person is:
	<jsp:getProperty name="person" property="name" />
	ID is:
	<jsp:getProperty name="person" property="empID" />
	--%>

	Request param name is : ${param.name} <br>
	Request param empID is : ${param.empID} <br>
	Request param food is : ${param.food} <br>
	First food request param : ${paramValues.food[0]} <br>
	Second food request param : ${paramValues.food[1]} <br>
</body>
</html>