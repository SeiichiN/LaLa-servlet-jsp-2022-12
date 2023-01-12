package util;

import java.util.List;

import model.Employee;
import model.MyError;
import model.logic.FindEmpByIdLogic;

public class ParamCheck {
	public void validate(Employee emp, List<MyError> errorList) {
		checkId(emp.getId(), errorList);
	}
	
	private void checkId(String id, List<MyError> errorList) {
		nullCheck("ID", id, errorList);
		if (id.matches("^EMP[0-9]{3}$")) {
			;
		} else {		
			MyError err = new MyError(id, "不正なIDです。");
			errorList.add(err);
		}
		duplicationCheck(id, errorList);
	}
	
	private void duplicationCheck(String id, List<MyError> errorList) {
		FindEmpByIdLogic logic =
				new FindEmpByIdLogic();
		if (logic.execute(id) != null) {
			MyError err = new MyError(id, "そのIDはすでに使われています。");
			errorList.add(err);
		}
	}
	
	/**
	 * valueが未入力でないか、チェックする
	 * @param key valueの項目名。エラー表示のときに項目名を表示する。
	 * @param value 調べたい項目。
	 * @param errorList MyErrorクラスのリスト。
	 */
	private void nullCheck(String key, String value, List<MyError> errorList) {
		if (value == null || value.length() == 0) {
			MyError err = new MyError(key, "未入力です。");
			errorList.add(err);
		}
	}
	
}   // class end
