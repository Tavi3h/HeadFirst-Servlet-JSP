package foo;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyIteratorTag extends TagSupport {

	private static final long serialVersionUID = -1454788758400904780L;
	
	private String[] movies = {"Spiderman", "Saved!", "Amelie"};
	private int movieCounter;

	@Override
	public int doStartTag() throws JspException {
		movieCounter = 0;
		pageContext.setAttribute("movie", movies[movieCounter++]);
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doAfterBody() throws JspException {
		if (movieCounter < movies.length) {
			pageContext.setAttribute("movie", movies[movieCounter++]);
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
