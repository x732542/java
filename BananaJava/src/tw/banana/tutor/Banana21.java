package tw.banana.tutor;

import tw.Ban.apis.Bike;
import tw.Ban.apis.Scooter;

public class Banana21 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Scooter s1= new Scooter();
		s1.changeGear(1);
		s1.upSpeed();s1.upSpeed();s1.upSpeed();
		s1.changeGear(4);
		s1.upSpeed();s1.upSpeed();s1.upSpeed();
		s1.downSpeed();
		System.out.println(s1.getSpeed());
	}

}
