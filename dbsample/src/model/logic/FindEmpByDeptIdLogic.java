package model.logic;

import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

public class FindEmpByDeptIdLogic {
	public List<Employee> execute(String deptId) {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empList = dao.findEmpByDeptId(deptId);
		return empList;
	}
}
