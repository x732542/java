package tw.banana.tutor;

public class Banana01 {
	public static void main(String[] args) {
		// byte 2^8, short2^16, int2^32, long 2^64 預設為int
		// float 小數點後六位,double小數點後十二位 
		// boolean 布林直 只有true 跟 false
		// char 字元 只能用單引號 '' 雙引號為字串 在java是物件

		
		byte var1;// [a-zA-Z$_ ][a-zA-z0-9$]*

		var1 = 126;
		var1 +=2;
		byte var2 = 127;

		System.out.println(var1);
		//被強迫轉成int 數值預設是int 
		System.out.println(var2+1);
	float v= 0.1f;
	double vv = 0.2;
	System.out.println(v+vv);
	}
}