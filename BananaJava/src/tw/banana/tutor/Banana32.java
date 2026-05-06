package tw.banana.tutor;

public class Banana32 {

	public static void main(String[] args) {
		//Brad321 obj1 = new Brad321();
		Brad321 obj1 = new Brad322();
		obj1.m1();
		obj1.m2();
		System.out.println("----");
		Brad321 obj2 = new Brad321() {
			@Override
			int m3(String b) {
				System.out.println("Brad321:m3(String)");
				return 0;
			}
			
			@Override
			void m2() {
				System.out.println("Brad321:m2()");
			}
		};
		obj2.m3("OK");
		obj2.m2();
		
	}
}
abstract class Brad321 {
	Brad321(){System.out.println("Brad321()");}
	void m1() {System.out.println("Brad321:m1()");}
	abstract void m2();
	abstract int m3(String b);
}
class Brad322 extends Brad321 {
	void m2() {System.out.println("Brad322:m2()");}
	int m3(String b) {return 1;}
}
class Brad323 extends Brad321 {
	void m2() {System.out.println("Brad323:m2()");}
	int m3(String b) {return 1;}
}