package model;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Gender gender;
	private Birthday birthday;
	private Dept dept;
	
	public Employee(int id, String name, Gender gender, Birthday birthday, Dept dept) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.dept = dept;
	}

	public String toString() {
		return id + ":" + name + ":" + gender.getName() + ":"
				+ birthday.getAge() + ":" + birthday.getText() + ":"
				+ dept.getName();
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Birthday getBirthday() {
		return birthday;
	}

	public Dept getDept() {
		return dept;
	}
	
}
