package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormSampleServlet")
public class FormSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, 
			              HttpServletResponse response) 
	                throws ServletException, IOException {
		
		// request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		String errorMsg = "";
		int idx = 0;
		if (name == null || name.length() == 0) {
			errorMsg += "名前が入力されていません。<br>";
		}
		if (gender == null || gender.length() == 0) {
			errorMsg += "性別が選択されていません。";
		} else {
			idx = Integer.parseInt(gender);
		}
		String[] gend = {"男性", "女性"};
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		if (errorMsg.length() > 0) {
			out.println(errorMsg);
		} else {
			out.println("name:" + name 
					+ " gender:" + gend[idx]);
		}
		out.println("</body></html>");
	}
}
