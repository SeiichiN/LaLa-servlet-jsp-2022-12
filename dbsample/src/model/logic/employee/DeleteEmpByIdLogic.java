package model.logic.employee;

import dao.DeptDAO;
import dao.EmployeeDAO;
import model.logic.user.DeleteUserByIdLogic;
import model.logic.user.IsExistsIdLogic;

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
