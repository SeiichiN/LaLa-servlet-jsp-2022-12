package test;
import java.util.List;

import dao.GenderDAO;
import model.Gender;

public class GenderFindAllTest {

	public static void main(String[] args) {
		GenderDAO dao = new GenderDAO();
		List<Gender> genderList = dao.findAll();
		for (Gender gender : genderList) {
			System.out.println(gender.getId() + ":" + gender.getName());
		}
	}

}
