<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 使用脚本代码 -->
	<%-- 
	Person is :
	<%=((foo.Person) request.getAttribute("person")).getName()%>
    --%>

	<!-- 使用标准动作 -->
	<%--  
	<jsp:useBean id="person" type="foo.Employee" scope="request">
		<jsp:setProperty name="person" property="name" value="Fred" />
	</jsp:useBean>
	Person Created by servlet:
	<jsp:getProperty name="person" property="name" />
	--%>
	<%--
	<jsp:useBean id="person" class="foo.Person" scope="request" />
	Dog's name is:<jsp:getProperty name="person" property="dog" />
	--%>
	Dog's name is: ${person.dog.name}
</body>
</html>