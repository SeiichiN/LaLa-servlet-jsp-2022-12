package servlet.dbmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.logic.CreateUserLogic;
import util.MyTool;

@WebServlet("/setPwNewUser")
public class SetPwNewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyTool tool = new MyTool();
		User newUser = tool.getUserByParam(request);
		request.setAttribute("newUser", newUser);
		String url = "/WEB-INF/jsp/manager/setPwNewUserConfirm.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
