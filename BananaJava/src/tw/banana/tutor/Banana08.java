package tw.banana.tutor;

public class Banana08 {

	public static void main(String[] args) {
		int i = 0;
		   
//		for ([1]進入迴圈必定先執行一次; [2]判斷條件是否成立，[5]; [4]執行完畢，收尾動作) {
//			[3]倘若條件成立，執行;
//		}
//		從[1]走到[5] 直到條件不成立
		for (printBrad(); i < 10; printLine()) {
			System.out.println(i++);
		}

	}
	
	static void printBrad() {
		System.out.println("Brad");
	}
	
	static void printLine() {
		System.out.println("-------");
	}
}
