package test;

import java.util.List;

import model.Dept;
import model.logic.GetDeptListLogic;

public class GetDeptListTest {

	public static void main(String[] args) {
		GetDeptListLogic logic =
				new GetDeptListLogic();
		List<Dept> deptList = logic.execute();
		for (Dept dept : deptList) {
			System.out.println
			  (dept.getId() + ":" + dept.getName());
		}
	}

}
