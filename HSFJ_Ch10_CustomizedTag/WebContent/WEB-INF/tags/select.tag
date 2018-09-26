<%@ tag body-content='empty' dynamic-attributes='tagAttrs'%>
<%@attribute name='optionsList' type='java.util.List' required='true' rtexprvalue='true'%>
<%@attribute name='name' required='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<select name='${name}'>
	<c:forEach var="attrEntry" items="${tagAttrs}">
			${attrEntry.key}='${attrEntry.value}'
	</c:forEach>

	<c:forEach var="color" items="${colorList}">
		<option value='${color}'>${color}</option>
	</c:forEach>
</select>