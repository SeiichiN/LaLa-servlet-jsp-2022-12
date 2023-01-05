package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteEmpByIdLogic;

@WebServlet("/deleteDone")
public class DeleteDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DeleteEmpByIdLogic logic =
				new DeleteEmpByIdLogic();
		String msg = null;
		if (logic.execute(id)) {
			msg = "削除成功";
		} else {
			msg = "削除失敗";
		}
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/deleteResult.jsp";
		request.getRequestDispatcher(url)
		       .forward(request, response);
	}

}
