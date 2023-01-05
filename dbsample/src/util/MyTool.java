package util;

import model.Dept;
import model.Employee;
import model.Gender;
import model.logic.GetDeptByIdLogic;
import model.logic.GetGenderByIdLogic;

public class MyTool {
	public static int parseInt(String param) {
		int value = 0;
		try {
			value = Integer.parseInt(param);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			value = -1;
		}
		return value;
	}
	
	public static Employee makeEmp(String name, String gender_id, String birthday, String dept_id) {
		Gender gender = new GetGenderByIdLogic().execute(gender_id);
		Dept dept = new GetDeptByIdLogic().execute(dept_id);
		Employee employee = new Employee(name, gender, birthday, dept);
		return employee;
	}
}
