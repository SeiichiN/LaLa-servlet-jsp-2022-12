package servlet.find;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.FindEmpByNameLogic;
import model.MyError;

@WebServlet("/findName")
public class FindEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		FindEmpByNameLogic logic = new FindEmpByNameLogic();
		List<Employee> empList = logic.execute(name);
		if (empList.size() < 1) {
			MyError myError = new MyError(name, "該当の社員は見つかりませんでした。"); 
			request.setAttribute("myError", myError);
		} else {
			request.setAttribute("empList", empList);
		}
		String url = "/WEB-INF/jsp/find/searchResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
