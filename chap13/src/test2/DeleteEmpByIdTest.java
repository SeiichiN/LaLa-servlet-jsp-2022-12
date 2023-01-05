package test2;

import model.DeleteEmpByIdLogic;

public class DeleteEmpByIdTest {

	public static void main(String[] args) {
		DeleteEmpByIdLogic logic =
				new DeleteEmpByIdLogic();
		String id = "EMP003";
		if (logic.execute(id)) {
			System.out.println(id + "の削除成功。");
		} else {
			System.out.println(id + "の削除失敗。");
		}

	}

}
