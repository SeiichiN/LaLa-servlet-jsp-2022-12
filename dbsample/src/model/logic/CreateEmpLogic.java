package model.logic;

import dao.EmployeeDAO;
import model.Employee;

public class CreateEmpLogic {
	public boolean execute(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.create(emp);
	}
}
