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
public class createConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MyError> errorList = new ArrayList<>();
		Employee emp = MyTool.getEmpByParameter(request);
		ParamCheck paramCheck = new ParamCheck();
		paramCheck.validate(emp, errorList);
		
		request.setAttribute("emp", emp);
		String url = null;
		if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
			url = "/WEB-INF/jsp/create/createEmp.jsp";
		} else {
			url = "/WEB-INF/jsp/create/createConfirm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	

}


