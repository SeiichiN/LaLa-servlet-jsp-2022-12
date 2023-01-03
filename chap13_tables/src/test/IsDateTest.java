package test;

import util.ParamCheck;

public class IsDateTest {

	public static void main(String[] args) {
		String dateText = "2016/09/30";
		ParamCheck paramCheck = new ParamCheck();
		if (paramCheck.isDate(dateText)) {
			System.out.println("正しい日付です。");
		} else {
			System.out.println("不正な日付です。");
		}

	}

}
