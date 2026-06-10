package tw.brad.apis;

import java.io.Serializable;

public class Bike implements Serializable{
	// has-a 擁有
	protected double speed;
	/*
	 * private   :本類別
	 * 沒寫      : 相同packge
	 * protected :子類別+相同packge
	 * public	 :全世界
	 */
	
	
	public Bike upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.4;
		return this;
	}

	public Bike downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.7;
		return this;

	}

	public double getSpeed() {
		return speed;
	}
}
