package foo;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class NestedLevelTagClassic extends TagSupport {
	private static final long serialVersionUID = -2296731474177326139L;
	private int nestLevel = 0;
	@Override
	public int doStartTag() throws JspException {
		nestLevel = 0;
		Tag parent = getParent();
		while (parent != null) {
			parent = parent.getParent();
			nestLevel++;
		}
		try {
			pageContext.getOut().println("<br>Tag nested level: " + nestLevel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
}
