package test;

import java.util.ArrayList;
import java.util.List;

import model.MyError;
import util.ParamCheck;

public class IsDateTest {

	private static final int ArrayList = 0;

	public static void main(String[] args) {
		String dateText = "西暦 1999-09-30";
		List<MyError> errorList = new ArrayList<>();
		ParamCheck p = new ParamCheck(errorList);
		if (p.isDate(dateText)) {
			System.out.println("正しい日付です。");
		} else {
			System.out.println("まちがった日付です。");
		}
	}

}
