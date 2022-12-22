package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex62")
public class RensyuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = new Random().nextInt(10);
		// int num = (int)(Math.random() * 10);
		Integer number = num;
		request.setAttribute("number", number);
		if (num % 2 == 1) {
			response.sendRedirect("/ex/redirected.jsp");
		} else {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher
				    ("/forwarded.jsp");
			dispatcher.forward(request, response);
		}
	}

}
