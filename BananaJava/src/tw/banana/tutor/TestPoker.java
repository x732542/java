package tw.banana.tutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestPoker {
	public static void main(String[] args) {
		// 1. 定義花色與點數
		String[] suits = { "黑桃", "紅心", "方塊", "梅花" };
		String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		// 2. 生成牌組 (使用 ArrayList 方便動態移除抽掉的牌)
		List<String> deck = new ArrayList<>();
		for (String s : suits) {
			for (String r : ranks) {
				deck.add(s + r);
			}
		}

		// 3. 洗牌 (這就是自動化的「亂數」邏輯)
		Collections.shuffle(deck);

		// 4. 抽牌示範 (抽 5 張)
		System.out.println("開始抽牌：");
		for (int i = 0; i < 5; i++) {
			// 每次從清單的最上方 (索引 0) 拿牌，並將其從牌組移除 (不放回)
			String pickedCard = deck.remove(0);
			System.out.println("第 " + (i + 1) + " 張是：" + pickedCard);
		}

		System.out.println("牌組剩餘張數：" + deck.size());
	}
}
