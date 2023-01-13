package test;

import java.util.ArrayList;
import java.util.List;

import model.MyError;
import util.ParamCheck;

public class IsDateTest {

	public static void main(String[] args) {
		String dateText = "1999-09-31";
		List<MyError> errorList = new ArrayList<>();
		ParamCheck p = new ParamCheck(errorList);
		if (p.isDate(dateText)) {
			System.out.println("正しい日付です。");
		} else {
			System.out.println("不正な日付です。");
		}

	}

}
