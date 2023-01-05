package servlet.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.logic.FindEmpByIdLogic;

@WebServlet("/edit")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		FindEmpByIdLogic logic = new FindEmpByIdLogic();
		Employee emp = logic.execute(id);
		request.setAttribute("emp", emp);
		String url = "/WEB-INF/jsp/update/editEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	private ParamEmp toParamEmp(Employee emp) {
		String age = "" + emp.getAge();
		return new ParamEmp(emp.getId(), emp.getName(), age);
	}
}
