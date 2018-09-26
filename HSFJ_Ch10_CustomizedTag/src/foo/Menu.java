package foo;

import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Menu extends TagSupport {

	private static final long serialVersionUID = -5580647932009064346L;

	private ArrayList<String> items;
	
	/*
	 *  子标记得到父标记的引用，引用调用该方法来获得当前子标记的属性。
	 *  该方法在doStartTag()和doEndTag()之间调用。
	 */
	
	public void addMenuItem(String item) {
		items.add(item);
	}
	
	@Override
	public int doStartTag() throws JspException {
		items = new ArrayList<>();
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().println("Menu items are: " + items);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 假设这里有一些复杂的构建菜单的代码
		return EVAL_PAGE;
	}
}
