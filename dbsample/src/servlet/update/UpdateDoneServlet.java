package servlet.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.logic.UpdateEmployeeLogic;
import util.MyTool;

@WebServlet("/updateDone")
public class UpdateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = MyTool.getEmpByParameter(request);
		UpdateEmployeeLogic logic = new UpdateEmployeeLogic();
		String msg = "";
		if (logic.execute(emp)) {
			msg = emp.getName() + "さんの情報を更新しました。";
		} else {
			msg = "情報を更新できませんでした。";
		}
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/update/updateResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
