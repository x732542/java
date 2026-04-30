package tw.banana.tutor;

public class HomeWork {
	public static void main(String[] args) {
		// final 確保變數不被影響
		final int ROWS = 10;
		final int CLOS = 9;
		final int START = 1;

		for (int k = 0; k < ROWS; k++) {
			// k:欄數
			for (int j = 1; j <= 1; j++) {
				// j:向下排序
				for (int i = START; i <= START+CLOS; i++) {
					// i: 向右排序

					// newi 數字
					int newi = i + k * 10;
					// 布林 確認時否為質數 要避過1 在此判斷>1 newi =1 時 為false
					boolean isPrime = (newi > 1);
					// 確認是否為質數 找到自己以外 餘數為0的存在 即為和數 **if後面不一定要else**
					// 數學上有個特性：如果一個數有因數，它一定會在自己的 「平方根」 之前出現。 改寫為<= 開完平方數
					for (int m = 2; m * m <= newi; m++) {
						if (newi % m == 0) {
							isPrime = false;
							break;
						}
					}
					if (isPrime == true) {
						System.out.printf("*%d*\t", newi);
					} else {
						System.out.printf("%d\t", newi);
					}
				}
				System.out.println();
			}
			System.out.println("--------------------------------------------------------------------------------");
		}
	}

}
