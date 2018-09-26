<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result Page</title>
</head>
<body>
	<h1 align="center">Beer Recommendations JSP</h1>
	<p>
		<%
			@SuppressWarnings("unchecked")
			List<String> styles = (List<String>) request.getAttribute("styles");
			Iterator<String> it = styles.iterator();
			while (it.hasNext()) {
				out.print("<br>try: " + it.next());
			}
		%>
	</p>
</body>
</html>