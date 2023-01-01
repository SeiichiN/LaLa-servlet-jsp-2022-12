package model;

import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDAO;

public class FindEmpByNameLogic {
	public List<Employee> execute(String name) {
		List<Employee> empList = new ArrayList<>();
		EmployeeDAO dao = new EmployeeDAO();
		empList = dao.findByName(name);
		return empList;
	}
}
