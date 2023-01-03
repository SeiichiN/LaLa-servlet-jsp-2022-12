package test;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.MyError;
import model.logic.CreateEmployeeLogic;
import model.logic.GetLastIdLogic;
import util.MyTool;
import util.ParamCheck;

public class CreateEmployeeTest {

	public static void main(String[] args) {
		Employee emp = MyTool.makeEmp("かぐや姫", "2", "1988-09-21", "d04");
		List<MyError> errorList = new ArrayList<>();
		ParamCheck paramCheck = new ParamCheck();
		paramCheck.validate(emp, errorList);
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
