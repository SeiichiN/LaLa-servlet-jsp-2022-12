package model.logic.employee;

import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

public class FindEmpByNameLogic {
	public List<Employee> execute(String name) {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empList = dao.findEmpByName(name);
		return empList;
	}
}
