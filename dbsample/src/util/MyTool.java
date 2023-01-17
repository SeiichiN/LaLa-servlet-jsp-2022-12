package util;

import javax.servlet.http.HttpServletRequest;

import model.Dept;
import model.Employee;
import model.Gender;
import model.logic.GetDeptByIdLogic;
import model.logic.GetGenderByIdLogic;

public class MyTool {
	public Employee getEmpByParam(HttpServletRequest request) {
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		String gender_id = request.getParameter("gender");
		String _birthday = request.getParameter("birthday");
		String birthday = reformBirthday(_birthday);
		String dept_id = request.getParameter("dept");
		
		Gender gender = new GetGenderByIdLogic()
				            .execute(gender_id);
		Dept dept = new GetDeptByIdLogic()
				        .execute(dept_id);
		Employee emp = 
				new Employee(id, name, gender, birthday, dept);
		return emp;
	}
	
	private String reformBirthday(String birthday) {
		if (birthday == null || birthday.length() == 0) {
			return "";
		}
		if (birthday.matches("^[0-9]{4}/[0-9]{1,2}/[0-9]{1,2}$")) {
			birthday = birthday.replaceAll("/",  "-");
		}
		String[] array = birthday.split("-");
		String year = array[0];
		String _month = "0" + array[1];
		String month = _month.substring(_month.length() - 2);
		String _day = "0" + array[2];
		String day = _day.substring(_day.length() - 2);
		return year + "-" + month + "-" + day;
	}
	
	public int parseInt(String numTxt) {
		int value = 0;
		try {
			value = Integer.parseInt(numTxt);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			value = -1;
		}
		return value;
	}
}
