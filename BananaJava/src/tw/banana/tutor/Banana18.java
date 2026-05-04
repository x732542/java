package tw.banana.tutor;

public class Banana18 {

	public static void main(String[] args) {
		int a = 10;
		while (a < 10) {
			System.out.println(a++);
		}
		System.out.println("---");
		a = 10;
		do {
			a++;
			System.out.println(a);
		} while (a < 10);
	}

}
