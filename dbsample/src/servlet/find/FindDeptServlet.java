package servlet.find;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.logic.employee.FindEmpByDeptIdLogic;

@WebServlet("/findDept")
public class FindDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptId = request.getParameter("deptId");
		FindEmpByDeptIdLogic logic = new FindEmpByDeptIdLogic();
		List<Employee> empList = logic.execute(deptId);
		request.setAttribute("empList", empList);
		request.setAttribute("article_title", "検索結果");
		String url = "/WEB-INF/jsp/find/searchResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
