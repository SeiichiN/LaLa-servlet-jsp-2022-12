package test;

import model.Gender;
import model.logic.GetGenderByIdLogic;

public class GetGenderByIdTest {

	public static void main(String[] args) {
		GetGenderByIdLogic logic =
				new GetGenderByIdLogic();
		Gender g = logic.execute("3");
		System.out.println(g);
	}

}
