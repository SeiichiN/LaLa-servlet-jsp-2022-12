package test;

import model.User;
import model.logic.user.FindUserByIdLogic;

public class FindUserByIdTest {

	public static void main(String[] args) {
		String id = "EMP001";
		String pass = "1111";
		FindUserByIdLogic logic = new FindUserByIdLogic();
		User user = logic.execute(id);
		if (pass.equals(user.getPass())) {
			System.out.println("登録ユーザーです。");
		} else {
			System.out.println("ユーザー名・パスワードが違います。");
		}
		
	}

}
