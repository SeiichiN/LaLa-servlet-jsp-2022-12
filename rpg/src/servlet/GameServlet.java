package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dragon;
import model.Hero;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hero hero = new Hero("桃太郎");
		Dragon dragon = new Dragon("やまたのおろち");
		
		ServletContext application = this.getServletContext();
		application.setAttribute("hero", hero);
		application.setAttribute("dragon", dragon);
		
		String url = "/WEB-INF/jsp/game.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || action.length() == 0) {
			;
		} else if (action.equals("attack")) {
			ServletContext application = this.getServletContext();
			Hero hero = (Hero) application.getAttribute("hero");
			Dragon dragon = (Dragon) application.getAttribute("dragon");
			// ヒーローの攻撃
			String heroAttack = hero.attack(dragon);
			request.setAttribute("heroAttack", heroAttack);
			// ドラゴンの攻撃
			String dragonAttack = dragon.attack(hero);
			request.setAttribute("dragonAttack", dragonAttack);
		} else {
			; // 逃げる場合
		}
		
		String url = "/WEB-INF/jsp/game.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
