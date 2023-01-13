package servlet.create;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.MyError;
import util.MyTool;
import util.ParamCheck;

@WebServlet("/createConfirm")
public class CreateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// formから送られてきたパラメータを受け取り、
		// Employeeビーンズにまとめる
		MyTool tool = new MyTool();
		Employee emp = tool.getEmpByParam(request);
		// empビーンズを使って、入力チェック。
		List<MyError> errorList = new ArrayList<>();
		ParamCheck paramCheck = new ParamCheck(errorList);
		paramCheck.validate(emp);
		
		request.setAttribute("emp", emp);
		String url = "";
		if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
			url = "/WEB-INF/jsp/create/createEmp.jsp";
		} else {
			url = "/WEB-INF/jsp/create/createConfirm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}	

}
