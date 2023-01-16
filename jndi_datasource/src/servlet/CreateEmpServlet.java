package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreateEmpLogic;
import model.Employee;

@WebServlet("/new")
public class CreateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		Employee emp = new Employee(id, name, age);
		CreateEmpLogic logic = new CreateEmpLogic();
		String msg = null;
		if (logic.execute(emp)) {
			msg = "登録成功";
		} else {
			msg = "登録失敗";
		}
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/createResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
