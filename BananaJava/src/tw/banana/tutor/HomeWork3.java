package tw.banana.tutor;

public class HomeWork3 {

	public static void main(String[] args) {
		byte[] records = new byte[100];
		for (byte i = 0; i < 100; i++) {
			// 灌鉛骰子 手動控制骰子點數
			byte pool[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
			// 隨機選取陣列內的內容
			int index = (int) (Math.random() * pool.length);
			// pool[index] 代表：請電腦去 pool 這個抽獎箱裡，把編號為 index 的那顆球拿出來。
			// byte dice = ... 代表：把拿出來的那顆球（點數），暫時存放在一個叫 dice 的變數裡，準備下一行塞進 aa[i]。
			byte dice = pool[index];
			records[i] = dice;

		}
		int[] count = new int[7];
		for (byte i = 0; i < records.length; i++) {
			// 基於骰子特性 可以放到1到6裡面
			byte point = records[i];
			count[point]++;
		}
		// 用迴圈印出 1 到 6 點的統計結果
		for (int i = 1; i <= 6; i++) {
			System.out.println(i + "點出現次數：" + count[i]);
		}
		System.out.println();

//----------------------------------------------------------------
		byte[] record = new byte[100];
		// 灌鉛骰子 亂數寫法
		for (byte i = 0; i < 100; i++) {
			// 用亂數<1的特性 定義機率
			double r = Math.random();
			byte dice;
			// 當亂數抽取到0.49999999 都是6 相當於50%的機率
			if (r < 0.5) {
				dice = 6;
				record[i] = dice;
			} else {
				// 公平骰子
				dice = (byte) (Math.random() * 6 + 1);
				record[i] = dice;
			}
		}
		int[] counts = new int[7];
		for (int i = 0; i < record.length; i++) {
			counts[record[i]]++;
		}
		for (int i = 1; i <= 6; i++) {
			System.out.println(i + "點出現次數：" + counts[i]);

		}
	}
}
