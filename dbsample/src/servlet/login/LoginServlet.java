package servlet.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MyError;
import model.User;
import model.logic.user.FindUserByIdLogic;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/jsp/login/login.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isError = false;
		List<MyError> errorList = new ArrayList<>();
		String id = request.getParameter("id").toUpperCase();
		nullCheck("id", id, errorList);
		if (errorList.size() > 0) { isError = true; }
		if (!isError && !checkId(id)) {
			MyError error = new MyError("ログイン失敗", "ID・パスワードがちがいます。");
			errorList.add(error);
			isError = true;
		}
		String pass = request.getParameter("pass");
		if (!isError) {
			nullCheck("pass", pass, errorList);
			if (errorList.size() > 0) {isError = true; }
		}
		
		if (!isError) {
			FindUserByIdLogic logic = new FindUserByIdLogic();
			User user = logic.execute(id);
			if (user != null && pass.equals(user.getPass())) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
			} else {
				MyError error = new MyError("ログイン失敗", "ID・パスワードがちがいます。");
				errorList.add(error);
				isError = true;
			}
		}
		if (isError) {
			request.setAttribute("errorList", errorList);		
			String url = "/WEB-INF/jsp/login/login.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/list");
		}
	}

	private void nullCheck(String key, String text, List<MyError> errorList) {
		if (text == null || text.length() == 0) {
			MyError error = new MyError(key, "文字が入力されていません。");
			errorList.add(error);
		}
	}

	private boolean checkId(String id) {
		final String REGEXP = "^EMP[0-9]{3}$";
		if (id.matches(REGEXP)) {
			return true;
		}
		return false;
	}
}
