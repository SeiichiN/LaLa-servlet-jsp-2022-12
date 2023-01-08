package test;

import util.MyTool;

public class GetAgeText {

	public static void main(String[] args) {
		String birthday = "1956-07-32";
		int age = MyTool.getAge(birthday);
		System.out.println("age:" + age);
	}

}
