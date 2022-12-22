package model;

public class RegisterUserLogic {
	public boolean execute(User user) {
		// 登録失敗 -- false
		// うまくいったことにしておく
		if (user == null) {
			System.out.println("登録できませんでした。");
			return false;
		}
		System.out.println(user.getName() + "を登録しました。");
		System.out.println("ログインID：" + user.getId());
		System.out.println("パスワード：" + user.getPass());
		return true;
	}
}
