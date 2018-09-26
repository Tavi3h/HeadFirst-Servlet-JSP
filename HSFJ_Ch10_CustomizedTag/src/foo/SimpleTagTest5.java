package foo;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import bean.Movie;

public class SimpleTagTest5 extends SimpleTagSupport {

	private List<Movie> movieList;

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Iterator<Movie> iter = movieList.iterator();
		while (iter.hasNext()) {
			Movie movie = iter.next();
			getJspContext().setAttribute("movie", movie);
			getJspBody().invoke(null);
		}
	}
}
