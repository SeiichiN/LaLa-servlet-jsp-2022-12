package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;

import model.Employee;
import model.Gender;
import model.MyError;
import model.logic.FindEmpByIdLogic;

public class ParamCheck {
	private List<MyError> errorList;
	private boolean isError;
	
	public ParamCheck(List<MyError> errorList) {
		this.errorList = errorList;
		this.isError = false;
	}
	
	public void validate(Employee emp) {
		checkId(emp.getId());
		checkName(emp.getName());
		checkGender(emp.getGender());
		checkBirthday(emp.getBirthday());
	}
	
	private void checkId(String id) {
		nullCheck("ID", id);
		if (isError) { return; }
		if (id.matches("^EMP[0-9]{3}$")) {
			;
		} else {		
			MyError err = new MyError(id, "不正なIDです。");
			errorList.add(err);
		}
		duplicationCheck(id);
	}
	
	private void duplicationCheck(String id) {
		FindEmpByIdLogic logic =
				new FindEmpByIdLogic();
		if (logic.execute(id) != null) {
			MyError err = new MyError(id, "そのIDはすでに使われています。");
			errorList.add(err);
		}
	}
	
	private void checkName(String name) {
		nullCheck("名前", name);
		if (isError) { return; }
		if (name.length() > 30) {
			MyError err = 
					new MyError("名前", "長すぎます。");
			errorList.add(err);
		}
	}
	
	private void checkGender(Gender gender) {
		nullCheck("性別", gender);
		if (isError) { return; }
		String gender_id = gender.getId();
		int result = new MyTool().parseInt(gender_id);
		if (result < 0) {
			MyError err = new MyError("性別", "数字ではありません。");
			errorList.add(err);
		}
	}
	
	private void checkBirthday(String birthday) {
		nullCheck("誕生日", birthday);
		// if (isError) { return; }
		if (birthday.matches("^[0-9]{4}/[0-9]{2}/[0-9]{2}$")) {
			birthday = birthday.replaceAll("/",  "-");
		}
		if (birthday.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")) {
			;   // OK
		} else {
			MyError err = new MyError("誕生日", "正しい書式ではありません。");
			errorList.add(err);
		}
		if (isDate(birthday)) {
			;
		} else {
			MyError err = new MyError("誕生日", "正しい日付ではありません。");
			errorList.add(err);
		}
	}
	/**
	 * dateTextが正しい日付であるかをチェックする。
	 * @param dateText (例) "1999-09-09" / "1999-09-31"
	 * @return
	 */
	public boolean isDate(String dateText) {
		final String DATE_PATTERN = "uuuu-MM-dd";
		DateTimeFormatter fmt = 
				DateTimeFormatter.ofPattern(DATE_PATTERN)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate.parse(dateText, fmt);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
	
	/**
	 * valueが未入力でないか、チェックする
	 * @param key valueの項目名。エラー表示のときに項目名を表示する。
	 * @param value 調べたい項目。
	 */
	private void nullCheck(String key, String value) {
		if (value == null || value.length() == 0) {
			MyError err = new MyError(key, "未入力です。");
			errorList.add(err);
			isError = true;
		}
	}
	
	private void nullCheck(String key, Object obj) {
		if (obj == null) {
			MyError err = new MyError(key, "未入力です");
			errorList.add(err);
			isError = true;
		}
	}
	
}   // class end
