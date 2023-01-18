package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.logic.employee.FindNameByIdLogic;

/**
 * Servlet implementation class FindNameByIdTest
 */
@WebServlet("/FindNameByIdTest")
public class FindNameByIdTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FindNameByIdLogic logic = new FindNameByIdLogic();
		String name = logic.execute("EMP006");
		System.out.println(name);
	}

}
