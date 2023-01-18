package model.logic.user;

import dao.UserDAO;
import model.User;

public class UpdateUserLogic {
	public boolean execute(User user) {
		UserDAO dao = new UserDAO();
		return dao.update(user);
	}
}
