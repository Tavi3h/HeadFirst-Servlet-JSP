package foo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MenuItem extends TagSupport {

	private static final long serialVersionUID = -5337690992450854984L;
	
	private String itemValues;

	public void setItemValues(String itemValues) {
		this.itemValues = itemValues;
	}
	
	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		Menu parent = (Menu) getParent();
		parent.addMenuItem(itemValues);
		return EVAL_PAGE;
	}
}
