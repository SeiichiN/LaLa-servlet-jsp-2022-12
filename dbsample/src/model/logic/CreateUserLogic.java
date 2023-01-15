package model.logic;

import dao.UserDAO;
import model.User;

public class CreateUserLogic {
	public boolean execute(User user) {
		UserDAO dao = new UserDAO();
		return dao.create(user);
	}
}
