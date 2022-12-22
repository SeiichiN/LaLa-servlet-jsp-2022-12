package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/RegisterConfirm")
public class RegisterConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name= request.getParameter("name");
		String pass = request.getParameter("pass");
		User registerUser = new User(id, name, pass);
		// jspにわたすためセッションに保存(そのあとも使う)
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		session.setMaxInactiveInterval(10);
		Integer intervalTime = session.getMaxInactiveInterval();
		session.setAttribute("registerUser", registerUser);
		session.setAttribute("sessionId", sessionId);
		session.setAttribute("intervalTime", intervalTime);
		
		String url = "/WEB-INF/jsp/registerConfirm.jsp";
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
