package servlet.find;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.logic.GetEmployeeListLogic;

@WebServlet("/list")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetEmployeeListLogic logic = new GetEmployeeListLogic();
		List<Employee> empList = logic.execute();
		request.setAttribute("empList", empList);
		String url = "/WEB-INF/jsp/find/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
