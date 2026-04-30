package tw.banana.tutor;

public class Banana07 {

	public static void main(String[] args) {
		double a = Math.random();
		int aa = (int)(a*101);
		switch(aa) {
		case 1 : System.out.println("a");break;
		case 10 : System.out.println("b");break;
		case 100 : System.out.println("c");break;
		default:System.out.println("xx");
		}
	}
}