package util;

import java.util.List;

import model.ExistEmpLogic;
import model.MyError;
import model.ParamEmp;

public class ParamCheck {
	public void validate(ParamEmp emp, List<MyError> errorList) {
		checkId(emp.getId(), errorList);
		checkName(emp.getName(), errorList);
		checkAge(emp.getAge(), errorList);
	}
	
	public void updateValidate(ParamEmp emp, List<MyError> errorList) {
		checkName(emp.getName(), errorList);
		checkAge(emp.getAge(), errorList);
	}

	private void checkId(String id, List<MyError> errorList) {
		nullCheck("ID", id, errorList);
		ExistEmpLogic logic = new ExistEmpLogic();
		if (logic.execute(id)) {
			MyError err = new MyError(id, "そのIDは存在しています。");
			errorList.add(err);
		}
		if (id.matches("^EMP[0-9]{3}$")) {
			;
		} else {
			MyError err = new MyError("ID", "文字が不正です。");
			errorList.add(err);
		}
	}
	
	private void checkName(String name, List<MyError> errorList) {
		nullCheck("名前", name, errorList);
		if (name.length() > 50) {
			MyError err = new MyError("名前", "文字が長すぎます(50文字以内)。");
			errorList.add(err);
		}
	}
	
	private void checkAge(String age, List<MyError> errorList) {
		nullCheck("年齢", age, errorList);
		int result = MyTool.parseInt(age);
		if (result < 0) {
			MyError err = new MyError("年齢", "数字ではありません。");
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
