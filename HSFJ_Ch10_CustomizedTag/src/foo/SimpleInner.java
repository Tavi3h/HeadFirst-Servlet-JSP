package foo;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleInner extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		// 访问传统父标记
		ClassicParent parent = (ClassicParent) getParent();
		getJspContext().getOut().print("Parent attribute is: " + parent.getName() + ";" + parent.getAttrs());
	}
}
