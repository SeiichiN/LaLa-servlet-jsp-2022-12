package toba;

import java.util.Random;

public class Saicoro {
	private int eye;
	
	public Saicoro() {
		this.eye = new Random().nextInt(6) + 1;
	}
	
	public int getEye() { return eye; }
}
