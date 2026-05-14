package tw.banana.tutor;

public class Banana72 {
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("OK");
			}
		}).start();
		System.out.println("----");
		new Thread(() -> System.out.println("ok2")).start();
	}
}
