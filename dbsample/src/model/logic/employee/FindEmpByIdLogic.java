package model.logic.employee;

import dao.EmployeeDAO;
import model.Employee;

public class FindEmpByIdLogic {
	public Employee execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.findEmpById(id);
	}
}
