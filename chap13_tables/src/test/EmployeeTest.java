package test;

import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empList = dao.findAll();
		for (Employee emp : empList) {
			System.out.println(emp);
		}
	}

}
