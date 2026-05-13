package tw.banana.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Banana68 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		Task1 t1 = new Task1();
		StopTask stop = new StopTask(timer);
		timer.schedule(t1, 3 * 1000);
		timer.schedule(stop, 4 * 1000);
		System.out.println("main");
	}
}

class Task1 extends TimerTask {
	int i;

	public void run() {
		System.out.println(i);
	}
}

class StopTask extends TimerTask {
	Timer timer;

	StopTask(Timer t1) {
		this.timer = t1;
	}

	public void run() {
		System.out.println("stop");
		timer.cancel();
		timer.purge();
		timer = null;
	}
}