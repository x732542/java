package tw.banana.tutor;

public class Banana73 {
	public static void main(String[] args) {
		MathOpenaction add1 = new MathOpenaction() {

			@Override
			public int operate(int a, int b) {
				return a + b;
			}
		};
		System.out.println(add1.operate(10, 3));
		System.out.println("------");
		MathOpenaction add2 = (a, b) -> a + b;
		System.out.println(add2.operate(10, 3));
		MathOpenaction add3 = (a, b) -> a * b;
		System.out.println(add3.operate(40, 3));
	}
}

interface MathOpenaction {
	int operate(int a, int b);
}