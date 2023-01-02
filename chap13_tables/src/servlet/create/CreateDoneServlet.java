package servlet.create;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.logic.CreateEmployeeLogic;
import model.ParamEmp;

@WebServlet("/createDone")
public class CreateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String gender_id = request.getParameter("gender_id");
		String birthday = request.getParameter("birthday");
		String dept_id = request.getParameter("dept_id");
		ParamEmp paramEmp = new ParamEmp(name, gender_id, birthday, dept_id);
		CreateEmployeeLogic logic = new CreateEmployeeLogic();
		String msg = "";
		if (logic.execute(paramEmp)) {
			msg = name + "さんを登録しました。";
		} else {
			msg = name + "さんを登録できませんでした。";
		}
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/create/createResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
