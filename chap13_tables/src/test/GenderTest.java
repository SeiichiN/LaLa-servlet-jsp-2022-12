package test;

import model.Gender;

public class GenderTest {

	public static void main(String[] args) {
		String gid = "2";
		String gname = "女性";
		Gender gender = new Gender(gid, gname);
		System.out.println(gid + ":" + gender.getName());

	}

}
