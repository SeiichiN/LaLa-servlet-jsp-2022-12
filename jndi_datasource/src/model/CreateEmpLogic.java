package model;

import dao.EmployeeDAO;

public class CreateEmpLogic {
	public boolean execute(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.create(emp);
	}
}
