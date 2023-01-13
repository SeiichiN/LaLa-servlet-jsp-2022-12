package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateUtil {
	private String pattern;
	
	public DateUtil(String pattern) {
		this.pattern = pattern;
	}

	public boolean isDate(String dateText) {
		DateTimeFormatter fmt = 
				DateTimeFormatter.ofPattern(pattern)
								 .withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate.parse(dateText, fmt);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}
