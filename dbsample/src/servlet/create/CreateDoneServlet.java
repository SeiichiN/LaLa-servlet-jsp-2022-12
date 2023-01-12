package servlet.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.logic.CreateEmployeeLogic;
import util.MyTool;

@WebServlet("/createDone")
public class CreateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = new MyTool().getEmpByParameter(request);
		CreateEmployeeLogic logic = new CreateEmployeeLogic();
		String msg = "";
		if (logic.execute(emp)) {
			msg = emp.getName() + "さんを登録しました。";
		} else {
			msg = "登録できませんでした。";
		}
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/create/createResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
