package model;

import java.io.Serializable;

public class Uranai implements Serializable {
	private String luck;
	private String today;
	
	public Uranai () {}
	public Uranai (String luck, String today) {
		this.luck = luck;
		this.today = today;
	}
	public String getLuck() {
		return luck;
	}
	public String getToday() {
		return today;
	}
	
	
}
