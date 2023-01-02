package model.logic;

import dao.EmployeeDAO;
import model.ParamEmp;

public class CreateEmployeeLogic {
	public boolean execute(ParamEmp emp) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.create(emp);
	}
}
