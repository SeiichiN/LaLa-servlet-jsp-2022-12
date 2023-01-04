package model;

import java.util.List;

import dao.EmployeeDAO;

/**
 * Employeeのリストを取得するクラス
 * @author Seiichi Nukayama
 */
public class GetEmployeeListLogic {

	public List<Employee> execute() {
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = empDAO.findAll();
		return empList;
	}
}
