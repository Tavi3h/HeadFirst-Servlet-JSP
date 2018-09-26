<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="mine" uri="nested_tag"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nested Tag Classic</title>
</head>
<body>
	<mine:ClassicParent name="ClassicParentTag" id="3" param="test">
		<mine:SimpleInner/>
	</mine:ClassicParent>
</body>
</html> 