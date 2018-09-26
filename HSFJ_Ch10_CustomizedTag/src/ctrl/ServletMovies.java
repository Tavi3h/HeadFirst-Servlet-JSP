package ctrl;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Movie;

@WebServlet("/ServletMovies")
public class ServletMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String moviename1 = request.getParameter("moviename1");
		String moviename2 = request.getParameter("moviename2");
		String moviename3 = request.getParameter("moviename3");
		String genre1 = request.getParameter("genre1");
		String genre2 = request.getParameter("genre2");
		String genre3 = request.getParameter("genre3");
		Movie movie1 = new Movie();
		Movie movie2 = new Movie();
		Movie movie3 = new Movie();
		
		movie1.setName(moviename1);
		movie1.setGenre(genre1);
		movie2.setName(moviename2);
		movie2.setGenre(genre2);
		movie3.setName(moviename3);
		movie3.setGenre(genre3);
		
		ArrayList<Movie> movieList = new ArrayList<>();
		movieList.add(movie1);
		movieList.add(movie2);
		movieList.add(movie3);
		
		request.setAttribute("movieCollection", movieList);
		request.getRequestDispatcher("movie.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
