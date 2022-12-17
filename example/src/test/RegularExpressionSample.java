package test;

import java.util.regex.Pattern;

public class RegularExpressionSample {

	public static void main(String[] args) {
		String str = "java";
		if (str.matches("^[0-9a-zA-Z]{4}$")) {
			System.out.println("一致した");
		}
		else {
			System.out.println("一致した");
		}
	}
	
	public static void preg() {
		String str = "java";
		Pattern pattern = Pattern.compile("^[0-9a-zA-Z]{4}$");
		if (pattern.matcher(str).matches()) {
			System.out.println("一致した");
		}
		else {
			System.out.println("一致した");
		}
	}

}
