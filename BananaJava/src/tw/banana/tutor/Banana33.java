package tw.banana.tutor;

public class Banana33 {

	public static void main(String[] args) {
		Brad331 obj1 = new Brad332();
		
	}
}

interface Brad331 {
	void m1();
	void m2();
}
interface Brad333 {
	void m3();
	void m4();
}
interface Brad334 extends Brad331, Brad333 {
	void m1234();
}
// Brad332 is-a Brad331, Brad333
class Brad332 extends Object implements Brad331, Brad333 {
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}
class Brad335 extends Brad332 implements Brad334 {
	public void m1234() {}
}