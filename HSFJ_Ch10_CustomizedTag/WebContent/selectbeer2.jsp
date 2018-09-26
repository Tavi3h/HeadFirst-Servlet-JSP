<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="formTags2" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beer Select</title>
</head>
<body>
	<form method="post" action="SelectBeer.do">
		<p>Select beer characteristics:</p>
		Color: 
		<formTags2:select name='color' size='1' optionsList='${applicationScope.colorList}' />
		<br>
		<br>
		<input type="submit">
	</form>
</body>
</html>