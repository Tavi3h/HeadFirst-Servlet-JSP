<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="myTags" uri="simpleTags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UseTag</title>
</head>
<body>
	<myTags:simple1 />
	<myTags:simple2>
		This is the body。${test}
	</myTags:simple2>
</body>
</html>