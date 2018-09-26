package foo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;

public class ClassicParent extends TagSupport implements DynamicAttributes {

	private static final long serialVersionUID = -1597233349247140527L;
	private Map<String, Object> tagAttrs = new HashMap<>();
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	// 为属性设置一个获取方法，方便子标记获取属性值
	public String getName() {
		return name;
	}
	public String getAttrs() {
		StringBuilder sb = new StringBuilder();
		Set<String> keySet = tagAttrs.keySet();
		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Object value = tagAttrs.get(key);
			sb.append(key + ":" + value.toString() + " ");
		}
		return sb.toString();
		
	}
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		tagAttrs.put(localName, value);
	}
}
