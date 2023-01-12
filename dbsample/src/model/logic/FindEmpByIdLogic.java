package model.logic;

import dao.EmployeeDAO;
import model.Employee;

public class FindEmpByIdLogic {
	public Employee execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.findEmpById(id);
		return emp;
	}
}
