<%@attribute name="fontColor" required="true"%>
<%@tag body-content="tagdependent"%>
<img alt="header" src="images/header.png">
<br>
<em>
	<strong>
		<font color="${fontColor}"><jsp:doBody/></font>
	</strong>
</em>
<br>
