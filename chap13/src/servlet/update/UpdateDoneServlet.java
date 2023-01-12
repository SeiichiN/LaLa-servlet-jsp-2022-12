package servlet.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreateEmployeeLogic;
import model.Employee;
import model.UpdateEmployeeLogic;
import util.MyTool;

@WebServlet("/updateDone")
public class UpdateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = MyTool.parseInt(request.getParameter("age"));
		Employee emp = new Employee(id, name, age);
		UpdateEmployeeLogic logic = new UpdateEmployeeLogic();
		String msg = "";
		if (logic.execute(emp)) {
			msg = name + "さんの情報を更新しました。";
		} else {
			msg = name + "さんの情報を更新できませんでした。";
		}
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/update/updateResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}