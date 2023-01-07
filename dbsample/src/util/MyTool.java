package util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

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
	public static Employee makeEmp(String id, String name, String gender_id, String birthday, String dept_id) {
		Gender gender = new GetGenderByIdLogic().execute(gender_id);
		Dept dept = new GetDeptByIdLogic().execute(dept_id);
		Employee employee = new Employee(id, name, gender, birthday, dept);
		return employee;
	}
	
	public static Employee getEmpByParameter(HttpServletRequest request) {
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		String gender_id = request.getParameter("gender_id");
		String birthday = request.getParameter("birthday");
		String dept_id = request.getParameter("dept_id");
		Employee emp = MyTool.makeEmp(id, name, gender_id, birthday, dept_id);
		return emp;
	}
	
	/**
	 * 日付文字列(uuuu-MM-dd)から年齢を導き出すメソッド。
	 * 日付文字列が不正であった場合、LocalDate.parse(birthday, fmt) のところで
	 * 例外が送出される。 
	 * @param birthday
	 * @return
	 */
	public static int getAge(String birthday) {
		final String DATE_FORMAT = "uuuu-MM-dd";
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_FORMAT);
		LocalDate localBirth = LocalDate.parse(birthday, fmt);
		LocalDate now = LocalDate.now();
		Period p = Period.between(localBirth, now);
		int age = p.getYears();
		return age;
	}
}
