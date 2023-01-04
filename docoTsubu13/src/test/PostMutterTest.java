package test;

import model.Mutter;
import model.PostMutterLogic;

public class PostMutterTest {

	public static void main(String[] args) {
		Mutter mutter = new Mutter("私", "こんにちは");
		PostMutterLogic logic = new PostMutterLogic();
		logic.execute(mutter);

	}

}
