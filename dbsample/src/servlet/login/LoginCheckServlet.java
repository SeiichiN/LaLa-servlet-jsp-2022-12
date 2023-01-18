package servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MyError;
import model.User;
import model.logic.user.FindUserByIdLogic;

@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toUpperCase();
		String pass = request.getParameter("pass");
		User user = new FindUserByIdLogic().execute(id);
		String url = null;
		if (pass != null && pass.length() > 0 && pass.equals(user.getPass())) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			url = "/list";
			
		} else {
			MyError error = new MyError("ログイン失敗", "ユーザー名・パスワードがちがいます。");
			request.setAttribute("error", error);
			url = "/WEB-INF/jsp/login/login.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
