package test2;

public class Hero {
	String name;
	int hp;
	private static int money;

	public Hero() {
	}
	public void setMoney(int money) {
		Hero.money = money;
	}
	
	public int getMoney() {
		return money;
	}
}
