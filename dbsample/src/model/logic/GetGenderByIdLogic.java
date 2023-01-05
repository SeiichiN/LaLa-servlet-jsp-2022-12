package model.logic;

import dao.GenderDAO;
import model.Gender;

public class GetGenderByIdLogic {
	public Gender execute(String id) {
		GenderDAO dao = new GenderDAO();
		return dao.findById(id);
	}
}
