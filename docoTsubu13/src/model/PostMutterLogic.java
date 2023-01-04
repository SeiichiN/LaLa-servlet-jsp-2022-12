package model;

import dao.MutterDAO;

public class PostMutterLogic {
	public void execute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		if (dao.create(mutter)) {
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}
	}
}
