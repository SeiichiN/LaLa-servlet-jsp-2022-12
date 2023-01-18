package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.List;

import model.Dept;
import model.Employee;
import model.Gender;
import model.MyError;
import model.logic.employee.FindEmpByIdLogic;

public class ParamCheck {
	private List<MyError> errorList;
	private boolean isError = false;
	
	public ParamCheck(List<MyError> errorList) {
		this.errorList = errorList;
	}
	
	public void validate(Employee emp, String mode) {
		if (mode.equals("create")) {
			checkId(emp.getId());
		}
		checkName(emp.getName());
		checkGender_id(emp.getGender());
		checkBirthday(emp.getBirthday());
		checkDept_id(emp.getDept());
	}
	
	public boolean validateDate(String dateText) {
		return isDate(dateText);
	}

	private void checkId(String id) {
		nullCheck("ID", id);
		if (isError) { 
			isError = false;
			return; 
		}
		if (id.matches("^EMP[0-9]{3}$")) {
			;
		} else {
			MyError err = new MyError("ID", "不正なIDです。");
			errorList.add(err);
		}
		duplicationCheck(id);
	}
	
	private void duplicationCheck(String id) {
		FindEmpByIdLogic logic = new FindEmpByIdLogic();
		if (logic.execute(id) != null) {
			MyError err = new MyError(id, "そのIDはすでに使われています。");
			errorList.add(err);
		}
	}
	
	private void checkName(String name) {
		nullCheck("名前", name);
		if (isError) {
			isError = false;
			return; 
		}
		if (name.length() > 50) {
			MyError err = new MyError("名前", "文字が長すぎます(50文字以内)。");
			errorList.add(err);
		}
	}
	
	private void checkGender_id(Gender gender) {
		nullCheck("性別", gender);
		if (isError) {
			isError = false;
			return;
		}
		String gender_id = gender.getId();
		nullCheck("性別", gender_id);
		int result = new MyTool().parseInt(gender_id);
		if (result < 0) {
			MyError err = new MyError("性別コード", "数字ではありません。");
			errorList.add(err);
		}
	}
	
	private void checkBirthday(String birthday) {
		nullCheck("誕生日", birthday);
		if (isError) {
			isError = false;
			return;
		}
//		if (birthday.matches("^[1-2][0-9]{3}/[0-9]{1,2}/[0-9]{1,2}$")) {
//			birthday = birthday.replaceAll("/", "-");
//		}
//		birthday = formatDate(birthday);
		if (birthday.matches("^[1-2][0-9]{3}-[0-9]{1,2}-[0-9]{1,2}$")) {
			;
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
	
	private void checkDept_id(Dept dept) {
		nullCheck("部署コード", dept);
		if (isError) {
			isError = false;
			return;
		}
		
		
		String dept_id = dept.getId();
		if (dept_id.matches("^d[0-9]{2}$")) {
			;
		} else {
			MyError err = new MyError("部署コード", "形式が正しくありません。");
			errorList.add(err);
		}
	}
	
	/**
	 * valueがnullでないか、チェックする。
	 * @param key valueの項目名。エラー表示のときに、項目名も表示するとわかりやすくなる。
	 * @param value 調べたい項目。
	 * @param errorList MyErrorクラスのリスト。
	 */
	public void nullCheck(String key, String value) {
		if (value == null || value.length() == 0) {
			MyError err = new MyError(key, "文字が入力されていません。");
			errorList.add(err);
			isError = true;
		}
	}
	
	private void nullCheck(String key, Object obj) {
		if (obj == null) {
			MyError err = new MyError(key, "未入力です。");
			errorList.add(err);
			isError = true;
		}
	}

	/**
	 * Date(java.time.LocalDate) が正しい日付であるかをチェックする。
	 * 
	 * (参考）
	 * 列挙型ResolverStyle
	 * https://docs.oracle.com/javase/jp/8/docs/api/java/time/format/ResolverStyle.html
	 * 
	 * Javaにおける日付文字列の書式チェック方法
	 * https://qiita.com/i_learnin/items/0e90036b2d7f664a249d
	 * 
	 * なぜ uuuu を使うのか
	 * Java8のDate and Time APIではyyyyじゃなくてuuuuを使う
	 * https://bufferings.hatenablog.com/entry/2017/10/23/000057
	 * 
	 * @param dateText
	 * @return
	 */
	public boolean isDate(String dateText) {
		final String DATE_PATTERN = "uuuu-MM-dd";
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
