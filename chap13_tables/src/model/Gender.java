package model;

import java.io.Serializable;

public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;
	private String[] names = {"不明", "男性", "女性", "その他"};
	private String id;
	private String name;
	
	public Gender() {}
	public Gender(String id) {
		this.id = id;
		int _id = Integer.parseInt(id);
		this.name = names[_id];
	}
	public Gender(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
