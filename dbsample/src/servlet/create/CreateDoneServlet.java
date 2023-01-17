package servlet.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.logic.CreateEmpLogic;
import util.MyTool;

@WebServlet("/createDone")
public class CreateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyTool tool = new MyTool();
		Employee emp = tool.getEmpByParam(request);
		CreateEmpLogic logic = new CreateEmpLogic();
		String msg = null;
		if (logic.execute(emp)) {
			msg = emp.getName() + "さんを登録しました。";
		} else {
			msg = "登録できませんでした。";
		}
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/create/createDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
