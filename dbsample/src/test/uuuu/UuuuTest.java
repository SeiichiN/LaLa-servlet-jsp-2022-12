package test.uuuu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UuuuTest {

	public static void main(String[] args) {
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("G yyyy/MM/dd");
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		LocalDate now = LocalDate.of(-234, 7, 21);
		String nowText1 = now.format(fmt1);
		String nowText2 = now.format(fmt2);
		String nowText3 = now.format(fmt3);
		System.out.println(nowText1);
		System.out.println(nowText2);
		System.out.println(nowText3);
	}

}
