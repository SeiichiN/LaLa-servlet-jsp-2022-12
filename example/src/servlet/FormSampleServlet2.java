package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormSampleServlet2")
public class FormSampleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	}
}
