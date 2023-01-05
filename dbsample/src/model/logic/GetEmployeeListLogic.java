package model.logic;

import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

public class GetEmployeeListLogic {
	public List<Employee> execute() {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empList = dao.findAll();
		return empList;
	}
}
