package tw.banana.tutor;

public class Banana11 {

	public static void main(String[] args) {
		final int ROWS = 2;
		final int CLOS = 4;
		final int START = 2;

		for (int k = 0; k < ROWS; k++) {
			for (int j = 1; j < 10; j++) {
				for (int i = START; i < START + CLOS; i++) {
					int newi = i + k * 4;
					int r = newi * j;
					System.out.printf("%d x %d = %d\t", newi, j, r);
				}
				System.out.println();
			}
			System.out.println("------");
		}
	}
}
