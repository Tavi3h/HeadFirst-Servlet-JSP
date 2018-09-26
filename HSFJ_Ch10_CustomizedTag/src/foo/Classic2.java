package foo;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Classic2 extends TagSupport {
	
	private static final long serialVersionUID = -4881953961793646665L;

	private JspWriter out;
	
	@Override
	public int doStartTag() throws JspException {
		out = pageContext.getOut();
		try {
			out.println("in doStartTag()");
		} catch (IOException e) {
			throw new JspException("IOException- " + e.toString());
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			out.println("in doEndTag()");
		} catch (IOException e) {
			throw new JspException("IOException- " + e.toString());
		}
		return EVAL_PAGE;
	}
	
}
