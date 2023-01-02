package servlet.create;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ParamEmp;

@WebServlet("/create")
public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/jsp/create/createEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * createConfirm.jspでユーザーがキャンセルを選択した場合、ここにパラメータが送られてくる。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String gender_id = request.getParameter("gender_id");
		String birthday = request.getParameter("birthday");
		String dept_id = request.getParameter("dept_id");
		ParamEmp paramEmp = new ParamEmp(name, gender_id, birthday, dept_id);
		request.setAttribute("paramEmp", paramEmp);
		String url = "/WEB-INF/jsp/create/createEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
