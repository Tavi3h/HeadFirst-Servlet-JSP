package com.example.taglib;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectTagHandler extends SimpleTagSupport implements DynamicAttributes {
	
	private Map<String, Object> tagAttrs = new HashMap<>();
	private static final String ATTR_TEMPLATE = "%s='%s' ";
	private static final String OPTION_TEMPLATE = " <option value='%1$s'> %1$s </option>";
	private List<String> optionsList;
	private String name;
	
	// 储存optionList属性
	public void setOptionsList(List<String> optionsList) {
		this.optionsList = optionsList;
	}
	// 储存name属性
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		// 开始 HTML<select>元素
		out.print("<select ");
		// 增加必要属性
		out.print(String.format(ATTR_TEMPLATE, "name", this.name));
		// 增加动态属性
		for (String attrName : tagAttrs.keySet()) {
			String attrDefinition = String.format(ATTR_TEMPLATE, attrName, tagAttrs.get(attrName));
			out.println(attrDefinition);
		}
		out.print(">");
		
		// 从optionList生成<option>元素
		for (String option : optionsList) {
			String optionTag = String.format(OPTION_TEMPLATE, option);
			out.println(optionTag);
		}
		
		// 结束HTML<select>元素
		out.print("</select>");
	}

	// 储存其他动态属性
	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		tagAttrs.put(localName, value);
	}
}
