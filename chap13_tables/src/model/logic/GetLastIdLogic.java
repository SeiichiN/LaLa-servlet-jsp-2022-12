package model.logic;

import dao.EmployeeDAO;

public class GetLastIdLogic {
	public int execute() {
		return EmployeeDAO.getLastId();
	}
}
