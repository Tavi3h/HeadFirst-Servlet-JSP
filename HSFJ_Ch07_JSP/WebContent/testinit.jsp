<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TestInit</title>
</head>
<body>

	<%!public void jspInit() {
		// 得到配置信息中的初始化参数，并将其作为ServletContext的一个属性保存起来
		String emailAddr = getServletConfig().getInitParameter("email");
		getServletContext().setAttribute("email", emailAddr);
	}%>

	<%
		// 获取该ServletContext中的属性
		String emailAddr = (String) application.getAttribute("email");
		out.println("mail: " + emailAddr);
	%>

</body>
</html>