package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormSampleServlet2")
public class FormSampleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
<<<<<<< HEAD
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		String errMsg = "";
		if (!password.matches("^[0-9a-zA-Z]{4}$")) {
			errMsg = "パスワードが不正です。";
		}
		System.out.println(errMsg);
		System.out.println("name:" + name);
		System.out.println("password:" + password);
=======
	protected void doPost(HttpServletRequest request, 
			              HttpServletResponse response) 
	                throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String passwd = request.getParameter("password");
		
		String errorMsg = "";
		int idx = 0;
		if (name == null || name.length() == 0) {
			errorMsg += "名前が入力されていません。<br>";
		}
		if (passwd.matches("^[0-9A-Za-z]{4}$")) {
			;
		} else {
			errorMsg += "パスワードがちがいます";
		}
		
>>>>>>> main
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
<<<<<<< HEAD
		out.println("name:" + name);
		if (errMsg.length() > 0) {
			out.println(errMsg);
		} else {
			out.println("password:" + password);
		}
		out.println("</body></html>");
	}
=======
		if (errorMsg.length() > 0) {
			out.println(errorMsg);
		} else {
			out.println("name:" + name 
					+ " passwd:" + passwd);
		}
		out.println("</body></html>");
	}

>>>>>>> main
}
