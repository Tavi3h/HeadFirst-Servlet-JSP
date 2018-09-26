package foo;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class NestedLevelTagSimple extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		int nestLevel = 0;
		SimpleTag parent = (SimpleTag) getParent();
		while (parent != null) {
			parent = (SimpleTag) parent.getParent();
			nestLevel++;
		}
		getJspContext().getOut().print("<br>Tag nested level: " + nestLevel);
		if (getJspBody() != null) {
			getJspBody().invoke(null);
		}
	}
}
