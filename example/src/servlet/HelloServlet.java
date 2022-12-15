package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long SerialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			               HttpServletResponse response)
	          throws ServletException, IOException {
		
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>hello</h1>");
		out.println("<p>コンテキストパス:" + contextPath + "</p>");
		out.println("<p>パス:" + servletPath + "</p>");
		out.println("</body></html>");
	}

}
