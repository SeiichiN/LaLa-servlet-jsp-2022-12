package servlet.dbmanager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.logic.user.DeleteUserByIdLogic;

@WebServlet("/deleteUserDone")
public class DeleteUserDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DeleteUserByIdLogic logic = new DeleteUserByIdLogic();
		String msg = null;
		if (logic.execute(id)) {
			msg = "ユーザーを削除しました。";
		} else {
			msg = "削除に失敗しました。";
		}
		String url = "/WEB-INF/jsp/manager/deleteUserDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
