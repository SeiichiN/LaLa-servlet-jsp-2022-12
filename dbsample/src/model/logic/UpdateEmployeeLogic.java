package model.logic;

import dao.EmployeeDAO;
import model.Employee;

public class UpdateEmployeeLogic {
	public boolean execute(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.update(emp);
	}
}
