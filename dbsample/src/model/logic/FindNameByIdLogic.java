package model.logic;

import dao.EmployeeDAO;

public class FindNameByIdLogic {
	public String execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.findNameById(id);
	}
}
