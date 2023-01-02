package test;

import model.Birthday;
import model.ParamEmp;
import model.logic.CreateEmployeeLogic;
import model.logic.GetLastIdLogic;

public class CreateEmployeeTest {

	public static void main(String[] args) {
		ParamEmp emp = new ParamEmp("かぐや姫", "3", "1988-09-21", "d04");
		CreateEmployeeLogic logic = new CreateEmployeeLogic();
		if (logic.execute(emp)) {
			System.out.println(emp.getName() + "の社員情報を保存しました。");
		} else {
			System.out.println(emp.getName() + "の社員情報の保存に失敗しました。");
		}
		GetLastIdLogic logic2 = new GetLastIdLogic();
		int lastId = logic2.execute();
		System.out.println("lastId: " + lastId);

	}

}
