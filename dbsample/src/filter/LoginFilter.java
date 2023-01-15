package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// サーブレットパスを調べる。
		String path = ((HttpServletRequest) request).getServletPath();
		System.out.println(path);
		// 以下であれば、そのままログインページを表示する。
		if (path.equals("/login") || 
			path.startsWith("/css") || 
			path.startsWith("/img") ||
			path.startsWith("/js")) {
			;
		} else {
			// セッションスコープに loginUserビーンズがなければ、未ログインである。
			HttpSession session = ((HttpServletRequest) request).getSession();
			if (session.getAttribute("loginUser") == null) {
				String url = ((HttpServletRequest)request).getContextPath() + "/login";
				((HttpServletResponse)response).sendRedirect(url);
				return;
			} 
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
