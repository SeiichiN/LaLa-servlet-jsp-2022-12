package servlet.dbmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import util.MyTool;

@WebServlet("/changePassword")
public class ChangePWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyTool tool = new MyTool();
		User loginUser = tool.getUserByParam(request);
		request.setAttribute("loginUser", loginUser);
		String url = "/WEB-INF/jsp/manager/updateUserConfirm.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
