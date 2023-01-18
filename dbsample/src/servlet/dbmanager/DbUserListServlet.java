package servlet.dbmanager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.logic.user.GetUserListLogic;

@WebServlet("/userList")
public class DbUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetUserListLogic logic = new GetUserListLogic();
		List<User> userList = logic.execute();
		request.setAttribute("userList", userList);
		String url = "/WEB-INF/jsp/manager/userList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
