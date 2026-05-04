package tw.banana.tutor;

import tw.Ban.apis.Bike;

public class Banana20 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1.getSpeed());
		b1.upSpeed();
		b1.upSpeed();
		b1.upSpeed();
		b1.upSpeed();
		b1.upSpeed();
		b1.upSpeed();
		b1.upSpeed();
		b1.upSpeed();
		System.out.println(b1.getSpeed());

		System.out.println("-------");
		b2.upSpeed();
		b2.upSpeed();
		b2.upSpeed();
		b2.upSpeed();
		b2.upSpeed();
		b2.upSpeed();
		b2.upSpeed();
		b2.downSpeed();
		b2.downSpeed();
		System.out.println(b2.getSpeed());
	}

}
