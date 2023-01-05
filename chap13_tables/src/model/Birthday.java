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
	private LocalDate localBirth;
	
	public Birthday() {}
	public Birthday(String text) {
		if (!validate(text)) {
			throw new IllegalArgumentException(text + ": 日付が不正です。");
		}
		this.text = text;
		setAgeFromBirthday(text);
		setSqlDateFromLocalBirth();
	}
	
	public Birthday(Date date)  {
		this.sqlDate = date;
		setAgeFromDate(date);
		this.text = date.toString();
	}
	
	/**
	 * sql.Date型から LocalDate型に変換し、年齢を求める。
	 * @param date : LocalDate <br> 
	 *                 データベースから取り出したカラムを想定。
	 */
	private void setAgeFromDate(Date date) {
		LocalDate localBirth = date.toLocalDate();
		LocalDate now = LocalDate.now();
		Period p = Period.between(localBirth, now);
		this.age = p.getYears();
	}
	
	private boolean validate(String text) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Const.DATE_FORMAT);
		try {
			this.localBirth = LocalDate.parse(text, dtf);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
	
	private void setSqlDateFromLocalBirth() {
		this.sqlDate = Date.valueOf(this.localBirth);
	}
	/**
	 * 日付文字列から sqlDate と年齢を求める
	 * @param text 日付文字列(正しい日付かどうかはわからない)。
	 */
	private void setAgeFromBirthday(String text) {
		LocalDate now = LocalDate.now();
		Period p = Period.between(this.localBirth, now);
		this.age = p.getYears();
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
