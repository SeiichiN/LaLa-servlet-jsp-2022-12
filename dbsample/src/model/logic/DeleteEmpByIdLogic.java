package model.logic;

import dao.EmployeeDAO;

public class DeleteEmpByIdLogic {
	public boolean execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.deleteById(id);
	}
}
