package model.logic;

import dao.DeptDAO;
import model.Dept;

public class GetDeptByIdLogic {
	public Dept execute(String id) {
		DeptDAO dao = new DeptDAO();
		return dao.findById(id);
	}
}
