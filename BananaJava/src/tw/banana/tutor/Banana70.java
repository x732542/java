package tw.banana.tutor;

public class Banana70 {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.add();
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.add();
			}
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(counter.count);
	}
}

class Counter {
	int count;

	public synchronized	void add() {
		count++;
	}
}