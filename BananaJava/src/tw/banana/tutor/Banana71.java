package tw.banana.tutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Banana71 {
	public static void main(String[] args) {
		System.out.println("Main Start");
		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.submit(() -> {
			System.out.println("A");
		});
		executor.submit(() -> {
			System.out.println("B");
		});
		executor.submit(() -> {
			System.out.println("C");
		});
		executor.submit(() -> {
			System.out.println("D");
		});

		executor.shutdown();
		System.out.println("Main Stop");

	}
}