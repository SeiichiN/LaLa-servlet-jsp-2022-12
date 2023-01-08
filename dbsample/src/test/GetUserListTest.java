package test;

import java.util.List;

import model.User;
import model.logic.GetUserListLogic;

public class GetUserListTest {

	public static void main(String[] args) {
		List<User> userList = new GetUserListLogic().execute();
		for (User user : userList) {
			System.out.println(user);
		}
	}

}
