package model.logic.user;

import dao.UserDAO;

public class DeleteUserByIdLogic {
	public boolean execute(String id) {
		UserDAO dao = new UserDAO();
		return dao.deleteById(id);
	}
}