package tw.banana.tutor;

public class HomeWork2 {
	public static void main(String[] args) {
//test 做出骰子 記錄100次的結果 並列印出每個數字出現的次數 **灌鉛骰子
		
		byte[] dicerecords = new byte[100];
			for (byte i = 0; i < 100; i++) {
				double temp = Math.random();
				byte dice = (byte) ((temp * 6) + 1);
//				System.out.println(dice);
// 把生出的變數塞進去
				dicerecords[i] = dice;
			
		}
		int[] counts = new int[7];
		for (byte i = 0; i < dicerecords.length; i++) {
			// 基於骰子特性 可以放到1到6裡面
//				byte point = dicerecords[i];
//					counts [point]++;
			//正常思路 對應 1~6
			if (dicerecords[i] == 1) counts[1]++;
			if (dicerecords[i] == 2) counts[2]++;
			if (dicerecords[i] == 3) counts[3]++;
			if (dicerecords[i] == 4) counts[4]++;
			if (dicerecords[i] == 5) counts[5]++;
			if (dicerecords[i] == 6) counts[6]++;
		}
		System.out.println("1點出現次數：" + counts[1]);
		System.out.println("2點出現次數：" + counts[2]);
		System.out.println("3點出現次數：" + counts[3]);
		System.out.println("4點出現次數：" + counts[4]);
		System.out.println("5點出現次數：" + counts[5]);
		System.out.println("6點出現次數：" + counts[6]);
	}
}
