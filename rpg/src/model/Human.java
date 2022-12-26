package model;

import java.util.List;

public abstract class Human {
	private String name;
	private int hp;
	private int attackHp;
	
	public Human() {
		this("ヒューマン");
	}
	public Human(String name) {
		this(name, 100, 10);
	}
	public Human(String name, int hp, int attackHp) {
		this.name = name;
		this.hp = hp;
		this.attackHp = attackHp;
	}
	
	public String toString() {
		return this.name + " hp:" + this.hp;
	}
	
	public String attack(Monster m) {
		String text1 = m.getName() + "を攻撃します。";
		// int damage = new Random().nextInt(this.attackHp + 1);
		int damage = (int)(Math.random() * (this.attackHp + 1));
		m.setHp(m.getHp() - damage);
		String text2 = m.getName() + "に" + damage + "のダメージを与えた。";
		return text1 + text2;
	}

	public void attack(List<Monster> mList) {
		if (this.getHp() <= 0) { return; }
		int num = (int)(Math.random() * mList.size());
		int damage = (int)(Math.random() * (this.getAttackHp() + 1));
		int newHp = mList.get(num).getHp() - damage;
		mList.get(num).setHp(newHp);
		
		System.out.print(this.getName() + " ==> ");
		System.out.print(damage + " ");
		System.out.print
		  (mList.get(num).getName() + " ");
		if (mList.get(num).getHp() <= 0) { return; }
		for (int i = 0; i < newHp / 10; i++) {
			System.out.print("*");
		}
		System.out.println();
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		if (hp <= 0) {
			hp = 0;
			System.out.println
			  (this.getName() + "は倒れた");
		}
		this.hp = hp;
	}

	public int getAttackHp() {
		return attackHp;
	}

	public void setAttackHp(int attackHp) {
		this.attackHp = attackHp;
	}
}
