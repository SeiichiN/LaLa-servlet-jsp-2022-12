package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Employee;
import model.GetEmpListLogic;

@WebServlet("/list")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetEmpListLogic logic = new GetEmpListLogic();
		List<Employee> empList = logic.execute();
		request.setAttribute("empList", empList);
		String url = "/WEB-INF/jsp/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
