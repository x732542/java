package tw.banana.tutor;

public class Banana67 {
	public static void main(String[] args) {
		Brad671 t1 = new Brad671("a");
		Brad671 t2 = new Brad671("b");
		Thread t3 = new Thread(new Brad672("c"));
		t1.start();
		t2.start();
		t3.start();
		System.out.println("main");
	}
}

class Brad671 extends Thread {
	String name;

	Brad671(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(name + " " + i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}

class Brad672 implements Runnable {
	String name;

	Brad672(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(name + " " + i);
		}
	}

}