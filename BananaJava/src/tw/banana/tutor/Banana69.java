package tw.banana.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Banana69 {
	public static void main(String[] args) {
		Timer timer = new Timer(false);
		timer.schedule(new Brad691(), 0, 1000);
		System.out.println("start");
		try {
			Thread.sleep(10 * 1000);

		} catch (Exception e) {
		}
		System.out.println("end");
	}
}

class Brad691 extends TimerTask {
	int i;

	public void run() {
		System.out.println(i++);
	}
}