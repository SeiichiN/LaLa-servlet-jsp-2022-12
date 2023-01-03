package model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import util.Const;

public class Birthday implements Serializable {
	private static final long serialVersionUID = 1L;
	private String text;
	private Date sqlDate;
	private int age;
	
	public Birthday() {}
	public Birthday(String text) {
		this.text = text;
		setAgeFromBirthday(text);
	}
	
	private void setAgeFromBirthday(String text) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Const.DATE_FORMAT);
		try {
			LocalDate localBirth = LocalDate.parse(text, dtf);
			this.sqlDate = Date.valueOf(localBirth);
			LocalDate now = LocalDate.now();
			Period p = Period.between(localBirth, now);
			this.age = p.getYears();
		} catch (DateTimeParseException e) {
			this.age = 0;
		}
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
