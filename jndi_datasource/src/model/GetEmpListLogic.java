package model;

import java.util.List;

import dao.EmployeeDAO;

public class GetEmpListLogic {
	public List<Employee> execute() {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.findAll();
	}
}
