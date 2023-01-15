package util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import model.Dept;
import model.Employee;
import model.Gender;
import model.User;
import model.logic.GetDeptByIdLogic;
import model.logic.GetGenderByIdLogic;

public class MyTool {
	public int parseInt(String param) {
		int value = 0;
		try {
			value = Integer.parseInt(param);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			value = -1;
		}
		return value;
	}
	
	/**
	 * サーブレットがフォームから id, name, gender_id, birthday, dept_id を受け取ったら、
	 * それをもとに Employeeビーンズにまとめあげる必要がある。このビーンズを CreateEmployeeLogic
	 * の execute()メソッドにわたすことになる。
	 * @param id
	 * @param name
	 * @param gender_id
	 * @param birthday
	 * @param dept_id
	 * @return Employee
	 */
	public Employee makeEmp(String id, String name, String gender_id, String birthday, String dept_id) {
		Gender gender = new GetGenderByIdLogic().execute(gender_id);
		Dept dept = new GetDeptByIdLogic().execute(dept_id);
		Employee employee = new Employee(id, name, gender, birthday, dept);
		return employee;
	}
	
	public Employee getEmpByParameter(HttpServletRequest request) {
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		String gender_id = request.getParameter("gender_id");
		String _birthday = request.getParameter("birthday");
		String birthday = formatDate(_birthday);
		String dept_id = request.getParameter("dept_id");
		Employee emp = new MyTool().makeEmp(id, name, gender_id, birthday, dept_id);
		return emp;
	}
	
	/**
	 * 日付文字列(uuuu-MM-dd)から年齢を導き出すメソッド。
	 * 日付文字列が不正であった場合、LocalDate.parse(birthday, fmt) のところで
	 * 例外が送出される。 
	 * @param birthday
	 * @return
	 */
	public int getAge(String birthday) {
		final String DATE_FORMAT = "uuuu-MM-dd";
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_FORMAT);
		LocalDate localBirth = LocalDate.parse(birthday, fmt);
		LocalDate now = LocalDate.now();
		Period p = Period.between(localBirth, now);
		int age = p.getYears();
		return age;
	}
	
	public String formatDate(String dateText) {
		if (dateText == null || dateText.length() == 0) {
			return "";
		}
		if (dateText.matches("^[1-2][0-9]{3}/[0-9]{1,2}/[0-9]{1,2}$")) {
			dateText = dateText.replaceAll("/", "-");
		}
		String[] array = dateText.split("-");
		String year = array[0];
		String _month = "0" + array[1];
		String month = _month.substring(_month.length() - 2);
		String _day = "0" + array[2];
		String day = _day.substring(_day.length() - 2);
		return year + "-" + month + "-" + day;
	}
	
	public User getUserByParam(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		User user = new User(id, name, pass);
		return user;
	}

	
}
