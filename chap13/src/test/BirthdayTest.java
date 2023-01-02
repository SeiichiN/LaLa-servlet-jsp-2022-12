package test;

import java.sql.Date;

import model.test.Birthday;

public class BirthdayTest {

	public static void main(String[] args) {
		Birthday birthday = new Birthday("1956-07-26");
		System.out.println("年齢：" + birthday.getAge());
		Date birth = birthday.getSqlDate();
	}

}
