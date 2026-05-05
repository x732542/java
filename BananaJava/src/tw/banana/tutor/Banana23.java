package tw.banana.tutor;

public class Banana23 {
	public static void main(String[] args) {
		Brad231 obj1 = new Brad231();
		// obj1.m1((byte)12, (byte)12);
	}
}

class Brad231 {
	void m1() {
		System.out.println("m1()");
	}

	// void m1(byte a) {System.out.println("m1(byte)");}
	void m1(int a) {
		System.out.println("m1(int)");
	}

	void m1(byte a, int b) {
		System.out.println("m1(byte,int)");
	}

	void m1(int a, byte b) {
		System.out.println("m1(int,byte)");
	}
}