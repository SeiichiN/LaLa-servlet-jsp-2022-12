package model.logic.user;

import dao.UserDAO;
import model.User;

public class FindUserByIdLogic {
	public User execute(String id) {
		UserDAO dao = new UserDAO();
		return dao.findUserById(id);
	}
}
