package servlet.update;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyError;
import model.ParamEmp;
import util.ParamCheck;

@WebServlet("/updateConfirm")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MyError> errorList = new ArrayList<>();
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		ParamEmp paramEmp = new ParamEmp(id, name, age);
		ParamCheck paramCheck = new ParamCheck();
		paramCheck.updateValidate(paramEmp, errorList);
		
		request.setAttribute("paramEmp", paramEmp);
		String url = null;
		if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
			url = "/WEB-INF/jsp/update/editEmp.jsp";
		} else {
			url = "/WEB-INF/jsp/update/updateConfirm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}