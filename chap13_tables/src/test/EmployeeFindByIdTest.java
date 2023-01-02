package test;

import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

public class EmployeeFindByIdTest {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.findById(3);
		System.out.println(emp);
	}

}
