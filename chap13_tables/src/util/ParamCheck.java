package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.List;

import model.Birthday;
import model.Dept;
import model.Employee;
import model.Gender;
import model.MyError;


public class ParamCheck {
	private final String DATE_PATTERN = "uuuu-MM-dd";
	
	public void validate(Employee emp, List<MyError> errorList) {
		checkName(emp.getName(), errorList);
		checkGender_id(emp.getGender(), errorList);
		checkBirthday(emp.getBirthday(), errorList);
		checkDept_id(emp.getDept(), errorList);
	}
	
	public boolean validateDate(String dateText) {
		return isDate(dateText);
	}
	
	private void checkName(String name, List<MyError> errorList) {
		nullCheck("名前", name, errorList);
		if (name.length() > 50) {
			MyError err = new MyError("名前", "文字が長すぎます(50文字以内)。");
			errorList.add(err);
		}
	}
	
	private void checkGender_id(Gender gender, List<MyError> errorList) {
		String gender_id = gender.getId();
		nullCheck("性別", gender_id, errorList);
		int result = MyTool.parseInt(gender_id);
		if (result < 0) {
			MyError err = new MyError("性別コード", "数字ではありません。");
			errorList.add(err);
		}
	}
	
	private void checkBirthday(Birthday birthday, List<MyError> errorList) {
		String text = birthday.getText();
		nullCheck("誕生日", text, errorList);
		if (text.matches("^[1-2][0-9]{3}/[0-9]{2}/[0-9]{2}$")) {
			text.replaceAll("/", "-");
			birthday = new Birthday(text);
		}
		if (text.matches("^[1-2][0-9]{3}-[0-9]{2}-[0-9]{2}$")) {
			;
		} else {
			MyError err = new MyError("誕生日", "正しい書式ではありません。");
			errorList.add(err);
		}
		if (isDate(text)) {
			;
		} else {
			MyError err = new MyError("誕生日", "正しい日付ではありません。");
			errorList.add(err);
		}
		if (birthday.getAge() > 100) {
			MyError err = new MyError("誕生日", "昔すぎます。");
			errorList.add(err);
		}
		if (birthday.getAge() < 1) {
			MyError err = new MyError("誕生日", "あなたは未来人ですか？");
			errorList.add(err);
		}
	}
	
	private void checkDept_id(Dept dept, List<MyError> errorList) {
		String dept_id = dept.getId();
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
	
	public boolean isDate(String dateText) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_PATTERN).withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate.parse(dateText, fmt);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
	
	public boolean isDateOld(String dateText) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    sdf.setLenient(false);         // 日付チェックを厳密にする
	    try{
//	        sdf.parse(dateText);
//	        return true;
	        Date parseDate = sdf.parse(dateText);
	        return sdf.format(parseDate).equals(dateText);
	        
	    }catch(ParseException e){
	        return false;
	    }
		
	}
	
}
