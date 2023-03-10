package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
		                   HttpServletResponse response)
	              throws ServletException, IOException {
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter dtf = 
				   DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		String today = dtf.format(now);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p>今日は" + today + "です。</p>");
		out.println("</body></html>");
	}

}
