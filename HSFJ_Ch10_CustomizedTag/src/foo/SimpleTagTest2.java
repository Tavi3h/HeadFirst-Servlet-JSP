package foo;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagTest2 extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		/*
		 * 这是说：“处理标记的体，并把它打印到响应”。
		 * null参数是指输出到响应，而不是输出到作为参数传入的某个writer。
		 */
		getJspContext().setAttribute("test", "testString");
		getJspBody().invoke(null);
	}
}
