package model;

public class ParamEmp {
	private String id;
	private String name;
	private String age;
	
	public ParamEmp(String id, String name, String age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}
	
}
