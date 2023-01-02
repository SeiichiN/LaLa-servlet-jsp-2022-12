package util;

import java.util.List;

import model.MyError;
import model.ParamEmp;

public class ParamCheck {
	public void validate(ParamEmp emp, List<MyError> errorList) {
		checkName(emp.getName(), errorList);
		checkGender_id(emp.getGender_id(), errorList);
		checkBirthday(emp.getBirthday(), errorList);
		checkDept_id(emp.getDept_id(), errorList);
	}
	
	private void checkName(String name, List<MyError> errorList) {
		nullCheck("名前", name, errorList);
		if (name.length() > 50) {
			MyError err = new MyError("名前", "文字が長すぎます(50文字以内)。");
			errorList.add(err);
		}
	}
	
	private void checkGender_id(String gender_id, List<MyError> errorList) {
		nullCheck("性別", gender_id, errorList);
		int result = MyTool.parseInt(gender_id);
		if (result < 0) {
			MyError err = new MyError("性別コード", "数字ではありません。");
			errorList.add(err);
		}
	}
	
	private void checkBirthday(String birthday, List<MyError> errorList) {
		nullCheck("誕生日", birthday, errorList);
		if (birthday.matches("^[1-2][0-9]{3}/[0-9]{2}/[0-9]{2}$")) {
			birthday.replaceAll("/", "-");
		}
		else if (birthday.matches("^[1-2][0-9]{3}-[0-9]{2}-[0-9]{2}$")) {
			;
		} else {
			MyError err = new MyError("誕生日", "正しい日付ではありません。");
			errorList.add(err);
		}
	}
	
	private void checkDept_id(String dept_id, List<MyError> errorList) {
		nullCheck("部署コード", dept_id, errorList);
		if (dept_id.matches("^d[0-9]{2}$")) {
			;
		} else {
			MyError err = new MyError("部署コード", "形式が正しくありません。");
			errorList.add(err);
		}
	}

	private void nullCheck(String key, String value, List<MyError> errorList) {
		if (value == null || value.length() == 0) {
			MyError err = new MyError(key, "文字が入力されていません。");
			errorList.add(err);
		}
	}
}
