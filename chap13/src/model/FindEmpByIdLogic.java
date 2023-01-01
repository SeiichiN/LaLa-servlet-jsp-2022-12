package model;

import dao.EmployeeDAO;

public class FindEmpByIdLogic {
	public Employee execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.findById(id);
	}
}
