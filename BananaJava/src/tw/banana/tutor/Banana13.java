package tw.banana.tutor;

public class Banana13 {

	public static void main(String[] args) {
		int[] a;
		a = new int[3];
		a[0] = 123;
		a[2] = 17;
		a[1] = 333;
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		// System.out.println(a[100]);
		System.out.println("---");
		for (int vv : a) { // for-each
			System.out.println(vv);
		}

	}
}
