package model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Birthday implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String DATE_FORMAT = "uuuu-MM-dd";
	private String text;
	private Date sqlDate;
	private int age;
	
	public Birthday() {}
	public Birthday(String text) {
		if (!validate(text)) {
			throw new IllegalArgumentException(text + ": 日付が正しくありません。");
		}
		this.text = text;
		this.sqlDate = toDate();
		this.age = toAge();
	}
	
	private int toAge() {
		LocalDate localBirth = toLocalDate(this.text);
		LocalDate now = LocalDate.now();
		Period p = Period.between(localBirth, now);
		return p.getYears();
	}
	
	private Date toDate() {
		LocalDate localBirth = toLocalDate(this.text);
		return Date.valueOf(localBirth);
	}
	
	private boolean validate(String text) {
		try {
			toLocalDate(text);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	private LocalDate toLocalDate(String text) throws DateTimeParseException {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_FORMAT);
		return LocalDate.parse(text, fmt);
	}
	public String getText() {
		return text;
	}
	public Date getSqlDate() {
		return sqlDate;
	}
	public int getAge() {
		return age;
	}
}
