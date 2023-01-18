package model.logic.employee;

import dao.EmployeeDAO;
import model.Employee;

public class CreateEmployeeLogic {
	public boolean execute(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.create(emp);
	}
}
