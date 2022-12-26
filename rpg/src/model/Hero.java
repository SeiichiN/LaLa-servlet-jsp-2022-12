package model;

public class Hero extends Human {
	
	public Hero() {
		this("ヒーロー");
	}
	public Hero(String name) {
		super(name, 100, 20);
	}

}
