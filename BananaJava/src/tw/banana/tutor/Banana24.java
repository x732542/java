package tw.banana.tutor;

public class Banana24 {

	public static void main(String[] args) {
		Brad241 obj1 = new Brad241(2);
		obj1.m1();
		Brad242 obj2 = new Brad242();
	}
}

/*
 * 1. 所有類別一定有建構式 => 有定義照你的, 無定義 => super class -> default constructor(no args)
 * 2. 所有 constructor 第一道敘述句 => 將 super 初始化 
 * 3. 建構式沒有在繼承
 */
class Brad241 extends Object {
	Brad241(int a) {
		super();
		System.out.println("Brad241(int)");
	}

	Brad241(String a) {
		System.out.println("Brad241(String)");
	}

	void m1() {
		System.out.println("Brad241:m1()");
	}
}

class Brad242 extends Brad241 {
	Brad242() {
		super("Brad");
		System.out.println("Brad242()");
	}
}