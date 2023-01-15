package servlet.dbmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.logic.FindNameByIdLogic;
import model.logic.IsExistsIdLogic;

@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/jsp/manager/createUser.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toUpperCase();
		IsExistsIdLogic logic = new IsExistsIdLogic();
		String url = "";
		if (logic.execute(id)) {
			String msg = "そのユーザーは、すでに管理ユーザーとして登録されています。";
			request.setAttribute("msg", msg);
			url = "/WEB-INF/jsp/manager/createUser.jsp";
		} else {
			FindNameByIdLogic nLogic = new FindNameByIdLogic();
			String name = nLogic.execute(id);
			User newUser = new User(id, name, "");
			request.setAttribute("newUser", newUser);
			url = "/WEB-INF/jsp/manager/setPwNewUser.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
