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
		// "/login"であれば、そのままログインページを表示する。
		if (path.equals("/login")) {
			chain.doFilter(request, response);
		} 
		// 他のurlなら、セッションを調べて、"loginUser"があれば、ログイン中だと判定。
		else {
			HttpSession session = ((HttpServletRequest) request).getSession();
			if (session.getAttribute("loginUser") != null) {
				chain.doFilter(request, response);
			} 
			// ログインしていないので、"/login"にリダイレクト
			else {
				String url = ((HttpServletRequest) request).getContextPath() + "/login";
				((HttpServletResponse) response).sendRedirect(url);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
