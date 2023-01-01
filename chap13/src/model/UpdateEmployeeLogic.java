package model;

import dao.EmployeeDAO;

public class UpdateEmployeeLogic {
	public boolean execute(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.update(emp);
	}
}
