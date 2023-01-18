package servlet.dbmanager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.logic.user.FindUserByIdLogic;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/jsp/manager/deleteUser.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toUpperCase();
		FindUserByIdLogic findLogic = new FindUserByIdLogic();
		User user = findLogic.execute(id);
		request.setAttribute("deleteUser", user);
		String url = "/WEB-INF/jsp/manager/deleteUserConfirm.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
