package model.logic.employee;

import dao.EmployeeDAO;

public class FindNameByIdLogic {
	public String execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.findNameById(id);
	}
}
