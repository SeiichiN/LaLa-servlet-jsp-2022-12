package servlet.delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteEmpByIdLogic;
import model.Employee;
import util.MyTool;

@WebServlet("/deleteDone")
public class DeleteDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		DeleteEmpByIdLogic logic = new DeleteEmpByIdLogic();
		String msg = "";
		if (logic.execute(id)) {
			msg = name + "さんの情報を削除しました。";
		} else {
			msg = name + "さんの情報を削除できませんでした。";
		}
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/delete/deleteResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
