package servlet.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import util.MyTool;

@WebServlet("/createConfirm")
public class CreateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// formから送られてきたパラメータを受け取り、
		// Employeeビーンズにまとめる
		MyTool tool = new MyTool();
		Employee emp = tool.getEmpByParam(request);
	}	// empビーンズを使って、入力チェック。

}
