package test;

import util.DateUtil;

public class Test {

	public static void main(String[] args) {
		String text = "西暦 1999/09/09";
		DateUtil dateUtil = new DateUtil("G yyyy/MM/dd");
		if (dateUtil.isDate(text)) {
			System.out.println("正しい日付です。");
		} else {
			System.out.println("不正な日付です。");
		}

	}

}
