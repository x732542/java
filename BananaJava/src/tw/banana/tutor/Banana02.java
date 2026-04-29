package tw.banana.tutor;

import java.util.Scanner;

public class Banana02 {

	public static void main(String[] args) {
//		int a;
//		System.out.println(a);
//		不初始化無法使用
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("x");
		int x = scanner.nextInt();
		System.out.printf("x =%d",x);
		int y = scanner.nextInt();
		System.out.printf("y= %d\n",y);
		
		int r1 = x+y;
		int r2 = x-y;
		int r3 = x*y;
		int r4 = x/y;
		int r5 = x%y;
		System.out.printf("%d + %d = %d\n",x,y,x+y);
		System.out.printf("%d - %d = %d\n",x,y,x-y);
		System.out.printf("%d * %d = %d\n",x,y,r3);
		System.out.printf("%d / %d = %d\n",x,y,r4);
		System.out.printf("%d / %d = %d......%d\n",x,y,r4,r5);
		
	}

}
