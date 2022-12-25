package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dragon;
import model.Hero;

@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Hero hero = (Hero) session.getAttribute("hero");
		if (hero == null) {
			hero = new Hero("桃太郎");
			session.setAttribute("hero", hero);
		}
		Dragon dragon = (Dragon) session.getAttribute("dragon");
		if (dragon == null) {
			dragon = new Dragon();
			session.setAttribute("dragon", dragon);
		}
		String dragonAttack = dragon.attack(hero);
		request.setAttribute("dragonAttack", dragonAttack);
		String url = "/WEB-INF/jsp/game.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sentaku = request.getParameter("sentaku").toLowerCase();
		String heroAttack = "";
		String dragonAttack = "";
		HttpSession session = request.getSession();
		Hero hero = (Hero) session.getAttribute("hero");
		if (sentaku.equals("x")) {
			Dragon dragon = (Dragon) session.getAttribute("dragon");
			heroAttack = hero.attack(dragon);
			dragonAttack = dragon.attack(hero);
		} else {
			heroAttack = hero.getName() + "は逃げ出した";
		}
		request.setAttribute("heroAttack", heroAttack);
		request.setAttribute("dragonAttack", dragonAttack);
		String url = "/WEB-INF/jsp/game.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
