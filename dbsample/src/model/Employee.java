package model;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Gender gender;
	private String birthday;
	private Dept dept;
	
	public Employee() {}
	public Employee(String name, Gender gender, String birthday, Dept dept) {
		this.id = 0;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.dept = dept;
	}
	public Employee(int id, String name, Gender gender, String birthday, Dept dept) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.dept = dept;
	}

	public String toString() {
		return name + ":" + gender.getName() + ":"
				+ birthday + ":" + dept.getName();
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

	public Dept getDept() {
		return dept;
	}
	public String getBirthday() {
		return birthday;
	}
	
}
