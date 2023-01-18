package servlet.dbmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.logic.user.UpdateUserLogic;
import util.MyTool;

@WebServlet("/changePasswordDone")
public class ChangePWDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyTool tool = new MyTool();
		User loginUser = tool.getUserByParam(request);
		UpdateUserLogic logic = new UpdateUserLogic();
		String msg = "";
		if (logic.execute(loginUser)) {
			msg = loginUser.getName() + "さんのパスワードを変更しました。";
		} else {
			msg = loginUser.getName() + "さんのパスワードは変更できませんでした。";
		}
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/manager/updateUserDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
