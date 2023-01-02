package model;

import java.io.Serializable;

public class ParamEmp implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String gender_id;
	private String birthday;
	private String dept_id;
	
	public ParamEmp() {}
	public ParamEmp(String name, String gender_id, String birthday, String dept_id) {
		this.name = name;
		this.gender_id = gender_id;
		this.birthday = birthday;
		this.dept_id = dept_id;
	}
	public String getName() {
		return name;
	}
	public String getGender_id() {
		return gender_id;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getDept_id() {
		return dept_id;
	}
	
}
