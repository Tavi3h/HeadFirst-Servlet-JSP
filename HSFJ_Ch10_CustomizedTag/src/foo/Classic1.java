package foo;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

// 通过扩展TagSupport，就实现了Tag和IterationTag。
public class Classic1 extends TagSupport {

	private static final long serialVersionUID = -5042963766139643896L;
	
	// 这里先只覆盖一个方法
	@Override
	public int doStartTag() throws JspException {
		// 传统标记从TagSupport继承了一个pageContext成员变量（SimpleTag要使用geJspContext()方法）
		JspWriter out = pageContext.getOut();
		// 不能声明IOException，所以要进行try/catch
		try {
			out.println("classic tag output");
		} catch (IOException e) {
			throw new JspException("IOException- " + e.toString());
		}
		// 必须返回一个int来告诉容器接下来做什么
		return SKIP_BODY;
	}
}
