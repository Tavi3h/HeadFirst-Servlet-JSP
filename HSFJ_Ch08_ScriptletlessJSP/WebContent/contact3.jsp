<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact us</title>
</head>
<body>
	<jsp:include page="header2.jsp" >
		<jsp:param value="We take the sting out of SOAP." name="subTitle"/>
	</jsp:include>
	<br>
	<em>We can help.</em>
	<br>
	<br>
	Contact us at: ${initParam.mainEmail}
</body>
</html>