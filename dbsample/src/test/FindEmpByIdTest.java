package test;

import model.Employee;
import model.logic.FindEmpByIdLogic;

public class FindEmpByIdTest {

	public static void main(String[] args) {
		FindEmpByIdLogic logic =
				new FindEmpByIdLogic();
		Employee emp = logic.execute("EMP001");
		System.out.println(emp);
	}

}
