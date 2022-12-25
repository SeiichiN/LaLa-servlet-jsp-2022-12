package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Animal;
import model.Dragon;
import model.Goblin;
import model.Hero;
import model.Human;
import model.Monster;
import model.Slime;

public class Main {

	public static void main(String[] args) {
		List<Human> hList = new ArrayList<>();
		hList.add(new Hero("桃太郎"));
		hList.add(new Animal("さる"));
		hList.add(new Animal("いぬ"));
		hList.add(new Animal("きじ"));
		
		List<Monster> mList = new ArrayList<>();
		mList.add(new Goblin("赤鬼"));
		mList.add(new Dragon("やまたのおろち"));
		mList.add(new Slime("スライム"));

		boolean getaway = false;
		while (true) {
			// モンスターの攻撃
			System.out.println("--- 鬼ヶ島軍団の攻撃 ---");
			for (Monster m : mList) {
				m.attack(hList);
			}
			for (int i = 0; i < hList.size(); i++) {
				if (hList.get(i).getHp() <= 0) {
					hList.remove(i);
				}
			}
			if (hList.isEmpty()) { break; }

			// ヒューマンの攻撃
			System.out.println("--- 桃太郎たちの攻撃 ---");
			for (Human h : hList) {
				h.attack(mList);
			}
			for (int i = 0; i < mList.size(); i++) {
				if (mList.get(i).getHp() <= 0) {
					mList.remove(i);
				}
			}
			if (mList.isEmpty()) { break; }
			
			printStatus(hList, mList);
			if (sentaku().equals("n")) {
				getaway = true;
				break;
			}

		}  // while end
		
		if (mList.isEmpty()) {
			System.out.println
			  ("鬼ヶ島軍団は全滅した。");
		}
		if (hList.isEmpty()) {
			System.out.println
			  ("桃太郎軍団は鬼ヶ島討伐に失敗した。");
		}
		if (getaway) {
			System.out.println
			  ("桃太郎軍団は逃げ出した。");
		}
	}  // main end
	
//	public static Monster selectEnemy(List<Monster> mList) {
//		System.out.println("どれを攻撃しますか？ No > ");
//		for (int i = 0; i < mList.size(); i++) {
//			System.out.print(i + ":" + mList.get(i).getName());
//		}
//		int no = new Scanner(System.in).nextInt();
//		return mList.get(no);
//	}
	
	public static String sentaku() {
		System.out.print
		  ("どうする？ x:攻撃 n:逃げる > ");
		String cmd = new Scanner(System.in).nextLine().toLowerCase();
		return cmd;
	}

	public static void printStatus
	         (List<Human> hList, List<Monster> mList) {
		System.out.println("-----------------------------");
		for (Human h : hList) {
			System.out.print(h + " ");
		}
		System.out.println();
		for (Monster m : mList) {
			System.out.print(m + " ");
		}
		System.out.println();
	}
}
