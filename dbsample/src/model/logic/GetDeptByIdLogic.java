package model.logic;

import dao.DeptDAO;
import model.Dept;

public class GetDeptByIdLogic {
	public Dept execute(String d_id) {
		DeptDAO dao = new DeptDAO();
		Dept dept = dao.findById(d_id);
		return dept;
	}
}
