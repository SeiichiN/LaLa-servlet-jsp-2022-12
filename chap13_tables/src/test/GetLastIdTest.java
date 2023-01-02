package test;

import dao.EmployeeDAO;
import model.logic.GetLastIdLogic;

public class GetLastIdTest {

	public static void main(String[] args) {
		GetLastIdLogic logic = new GetLastIdLogic();
		int lastId = logic.execute();
		System.out.println("lastId: " + lastId);
	}

}
