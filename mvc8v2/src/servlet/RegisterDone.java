package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterDone")
public class RegisterDone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User registerUser 
		    = (User) session.getAttribute("registerUser");
		RegisterUserLogic logic = new RegisterUserLogic();
		String errMsg = null;
		if (! logic.execute(registerUser)) {
			errMsg = "登録に失敗しました。";
		}
		session.removeAttribute("registerUser");
		request.setAttribute("errMsg", errMsg);
		
		String path = "/WEB-INF/jsp/registerDone.jsp";

		RequestDispatcher dispatcher =
				request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}

}
