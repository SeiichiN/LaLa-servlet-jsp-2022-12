package model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Birthday implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private String text;
	private Date sqlDate;
	private int age;
	
	public Birthday() {}
	public Birthday(String text) {
		this.text = text;
		this.age = getAgeFromBirthday(text);
	}
	
	private int getAgeFromBirthday(String text) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
		LocalDate localBirth = LocalDate.parse(text, dtf);
		this.sqlDate = Date.valueOf(localBirth);
		LocalDate now = LocalDate.now();
		Period p = Period.between(localBirth, now);
		return p.getYears();
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
