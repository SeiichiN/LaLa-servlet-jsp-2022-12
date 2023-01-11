package model;

import java.io.Serializable;

public class Gender implements Serializable {
	private String id;
	private String name;
	
	public Gender () {}
	public Gender(String id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return id + ":" + name;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
