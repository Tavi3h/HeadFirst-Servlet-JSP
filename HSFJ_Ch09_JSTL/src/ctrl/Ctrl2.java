package ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ctrl2
 */
@WebServlet("/Ctrl2")
public class Ctrl2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] movieArray1 = {"Matrix Revolutuibs", "Kill Bill", "Boondock Saints"};
		String[] movieArray2 = {"Amelie", "Return of the King", "Mean Girls"};
		List<String[]> movieList = new ArrayList<>();
		movieList.add(movieArray1);
		movieList.add(movieArray2);
		request.setAttribute("movieList", movieList);
		request.getRequestDispatcher("foreach2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
