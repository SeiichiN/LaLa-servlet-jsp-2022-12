package model;

import dao.EmployeeDAO;

public class ExistEmpLogic {
	/**
	 * その id をもつ社員が存在するか？
	 * @param id
	 * @return true 存在する<br>
	 *         false 存在しない
	 */
	public boolean execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.findById(id);
		if (emp == null) {
			return false;
		}
		return true;
	}
}
