package test;

import java.util.List;

import model.Employee;
import model.logic.employee.GetEmpListLogic;

public class GetEmpListTest {

	public static void main(String[] args) {
		GetEmpListLogic logic = new GetEmpListLogic();
		List<Employee> empList = logic.execute();
		for (Employee emp : empList) {
			System.out.println(emp);
		}
	}

}
