package servlet.create;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreateEmployeeLogic;
import model.Employee;
import util.MyTool;

@WebServlet("/createDone")
public class CreateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = MyTool.parseInt(request.getParameter("age"));
		Employee emp = new Employee(id, name, age);
		CreateEmployeeLogic logic = new CreateEmployeeLogic();
		String msg = "";
		if (logic.execute(emp)) {
			msg = "社員:" + name + "さんを登録しました。";
		} else {
			msg = "登録できませんでした。";
		}
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/create/createDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
