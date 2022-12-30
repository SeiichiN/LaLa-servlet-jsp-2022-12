package util;

public class MyTool {
	public static int parseInt(String param) {
		int value = 0;
		try {
			value = Integer.parseInt(param);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			value = -1;
		}
		return value;
	}

}
