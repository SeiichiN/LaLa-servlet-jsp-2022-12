package model;

import java.util.List;

/**
 * モンスタークラス（抽象クラス）
 * このクラスをもとに、Dragonクラス、Goblinクラス、
 * Slimeクラスを作成する。
 * 
 * https://xxxxx.com/dddd.html
 * 
 * @author Seiichi Nukayama
 *
 */
public abstract class Monster {
	private String name;
	private int hp;
	private int attackHp;

	public Monster() {
		this("モンスター");
	}

	public Monster(String name) {
		this(name, 100, 20);
	}

	public Monster(String name, int hp, int attackHp) {
		this.name = name;
		this.hp = hp;
		this.attackHp = attackHp;
	}

	public String toString() {
		String _hp = "*";
		for (int i = 0; i < this.hp / 10; i++) {
			_hp = _hp + "*";
		}
		return this.name + ":" + this.hp + " " + _hp;
	}

	public String attack(Hero h) {
		String resultText = "";
		if (this.hp <= 0) {
			return "";
		}
		resultText = resultText + this.name + " ==> " + h.getName() + " ";
		// int damage = new Random().nextInt(this.attackHp + 1);
		int damage = (int) (Math.random() * (this.attackHp + 1));
		String damageText = "";
		for (int i = 0; i <= damage / 5; i++) {
			damageText += "X";
		}
		h.setHp(h.getHp() - damage);
		return resultText + damageText + " " + damage;
	}
	
	/**
	 * 桃太郎軍団の一人を乱数によって決め、
	 * その一人を攻撃するメソッド。
	 * 
	 * @param hList -- 桃太郎軍団(桃太郎、さる、きじ、いぬ)
	 */
	public void attack(List<Human> hList) {
		// 鬼ヶ島軍団のそれぞれのHPが0以下なら、もどる。
		if (this.getHp() <= 0) { return; }
		// 0...3のどれにするかを決める。
		int num = (int)(Math.random() * hList.size());
		int damage = (int)(Math.random() * (this.getAttackHp() + 1));
		int newHp = hList.get(num).getHp() - damage;
		hList.get(num).setHp(newHp);
		
		System.out.print(this.getName() + " ==> ");
		System.out.print(damage + " ");
		System.out.print
		  (hList.get(num).getName() + " ");
		if (hList.get(num).getHp() <= 0) { return; }
		for (int i = 0; i < newHp / 10; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	public void run() {

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
