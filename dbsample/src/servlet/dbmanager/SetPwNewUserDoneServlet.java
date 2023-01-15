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

@WebServlet("/setPwNewUserDone")
public class SetPwNewUserDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyTool tool = new MyTool();
		User newUser = tool.getUserByParam(request);
		CreateUserLogic logic = new CreateUserLogic();
		String msg = null;
		if (logic.execute(newUser)) {
			msg = newUser.getName() + "さんを管理ユーザーとして設定しました。";
			request.setAttribute("newUser", newUser);
		} else {
			msg = newUser.getName() + "さんは管理ユーザーとして設定できませんでした。";
		}
		String url = "/WEB-INF/jsp/manager/setPwNewUserDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
