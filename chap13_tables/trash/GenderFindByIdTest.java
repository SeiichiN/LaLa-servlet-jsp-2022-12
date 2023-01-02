package test;

import dao.GenderDAO;
import model.Gender;

public class GenderFindByIdTest {

	public static void main(String[] args) {
		GenderDAO dao = new GenderDAO();
		Gender gender = dao.findById("2");
		System.out.println(gender.getId() + ":" + gender.getName());
	}

}
