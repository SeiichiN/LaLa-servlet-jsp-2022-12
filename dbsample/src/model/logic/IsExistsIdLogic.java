package model.logic;

import dao.UserDAO;

public class IsExistsIdLogic {
	public boolean execute(String id) {
		UserDAO dao = new UserDAO();
		return dao.isExistsById(id);
	}
}
