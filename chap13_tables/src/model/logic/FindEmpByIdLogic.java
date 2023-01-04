package model.logic;

import dao.EmployeeDAO;
import model.Employee;

public class FindEmpByIdLogic {
	public Employee execute(int id) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.findById(id);
	}
}
