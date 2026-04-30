package tw.banana.tutor;

public class HomeWork2 {
	public static void main(String[] args) {
		byte[] dicerecords = new byte[100];
		for (byte i = 0; i < 100; i++) {
			double temp = Math.random();
			byte dice = (byte) ((temp * 6) + 1);
//			System.out.println(dice);
			dicerecords[i] = dice;
			// 定義空陣列
		}
		int[] counts = new int[7];
		for (byte i = 0; i < dicerecords.length; i++) {
			if (dicerecords[i] == i) {
				counts[i]++;
			}

		}
		System.out.println("1點出現次數：" + counts[1]);
		System.out.println("2點出現次數：" + counts[2]);
		System.out.println("3點出現次數：" + counts[3]);
		System.out.println("4點出現次數：" + counts[4]);
		System.out.println("5點出現次數：" + counts[5]);
		System.out.println("6點出現次數：" + counts[6]);
	}
}
