package model.test;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Birthday implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private String birthday;
	private Date sqlDate;
	private int age;
	
	public Birthday() {}
	public Birthday(String birthday) {
		this.birthday = birthday;
		this.age = getAgeFromBirthday(birthday);
	}
	
	private int getAgeFromBirthday(String birthday) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
		LocalDate localBirth = LocalDate.parse(birthday, dtf);
		this.sqlDate = Date.valueOf(localBirth);
		LocalDate now = LocalDate.now();
		Period p = Period.between(localBirth, now);
		return p.getYears();
	}
	public String getBirthday() {
		return birthday;
	}
	public Date getSqlDate() {
		return sqlDate;
	}
	public int getAge() {
		return age;
	}
}
