package model.logic;

import dao.DeptDAO;
import dao.EmployeeDAO;

public class DeleteEmpByIdLogic {
	public boolean execute(String id) {
		IsExistsIdLogic isExistsIdLogic = new IsExistsIdLogic();
		if (isExistsIdLogic.execute(id)) {
			DeleteUserByIdLogic deleteUserByIdLogic = new DeleteUserByIdLogic();
			deleteUserByIdLogic.execute(id);
		}
		EmployeeDAO dao = new EmployeeDAO();
		return dao.deleteById(id);
	}
}
