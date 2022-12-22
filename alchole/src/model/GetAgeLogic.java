package model;

public class GetAgeLogic {
	public void execute(User user) {
		String text = null;
		if (user.getAge() < 20) {
			text = user.getName() 
					+ "さんはお酒を飲めません";
		} else {
			text = user.getName() 
					+ "さん、飲み過ぎに注意しましょう";
		}
		user.setText(text);
	}
}
