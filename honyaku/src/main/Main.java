package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String word = request.getParameter("word");
		String urlTxt = "https://script.google.com/macros/s/AKfycbxj-0deGFSNF0iPrumoayDWJp7oU4gFvMPa_1iFT4lkXM1EK_EyOPGgAVyjNZn23wsg/exec?text="
				+ word + "&source=en&target=ja";
		URL u = new URL(urlTxt);
		InputStream is = u.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String jsondata = reader.readLine();
		String data = null;
		if (jsondata != null) {
			JSONObject jsonObj = new JSONObject(jsondata);
			data = jsonObj.getString("text");
		} else {
			data = "失敗";
		}
		request.setAttribute("word", word);
		request.setAttribute("data", data);
		String url = "/WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
