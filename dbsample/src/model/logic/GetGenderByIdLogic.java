package model.logic;

import dao.GenderDAO;
import model.Gender;

public class GetGenderByIdLogic {
	public Gender execute(String gender_id) {
		GenderDAO dao = new GenderDAO();
		Gender gender = dao.findById(gender_id);
		return gender;
	}
}
