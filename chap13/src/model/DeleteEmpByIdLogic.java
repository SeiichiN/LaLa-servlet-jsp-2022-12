package model;

import dao.EmployeeDAO;

public class DeleteEmpByIdLogic {
	public boolean execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
<<<<<<< HEAD
		return dao.deleteById(id);
=======
		return dao.remove(id);
>>>>>>> main
	}
}
