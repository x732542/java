package tw.banana.tutor;

public class Banana26 {
	public static void main(String[] args) {
		String s1 = new String("Brad");
		String s2 = new String("Brad");
		String s3 = "Brad";
		String s4 = "Brad";
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		System.out.println(s1 == s3);
		int a = 10, b = 10;
		System.out.println(a == b);
		System.out.println("----");
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s3.equals(s4));
	}
}