package scope;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = (String) request.getAttribute("word");
		text = text + " This is SecondServlet";
		System.out.println(text);
		request.setAttribute("word", text);
		
		RequestDispatcher d =
				request.getRequestDispatcher("/last.jsp");
		d.forward(request, response);
	}

}
