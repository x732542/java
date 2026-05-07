package tw.banana.tutor;

import java.util.ArrayList;
import java.util.List;

/*
 * 使用陣列 先從順時針開始數，當數到第一個水手(O)時，將此去除後轉換方向，換成逆時針開始數，
 * 之後以此類推。 
 * 規則如下： 
 * 	由input.txt檔案讀取字串 字串內容為隨機的O與X組合 (注意：O與X的數量皆不固定) 
 * 	1. 將字串的頭尾鏈結起來(圍成一個圓形) 
 *  2. 並計算一個神奇數字 
 *  3. 從字串的頭開始數 
 *  4. 數到神奇數字時將該字元去除 
 *  5.去除該字元後，依照這次的方向規定重複步驟4
 */
public class Banana38 {
	public static void main(String[] args) {
		String input = "oxxooxooxoxooxox";
		char[] chars = input.toCharArray();
		
		List<Character> list = new ArrayList<>();
		for (char c : chars) list.add(c);
		
		int magicNumber = list.size(); // 神奇數字 = 串列原始長度
		int index = 0;
		int dir = 1;	// 1 : 順; -1 : 逆
		int counter = 0;
		
		while (list.contains('x')) {
			char current = list.get(index);
			
			
			if (current == 'x') {
				list.remove(index);
				if (list.isEmpty()) break;
				
				dir *= -1;
				index += dir;
				counter++;
			}else {
				index += dir;
			}
			
			if (index >= list.size()) {
				index = 0;
			}else if (index < 0) {
				index = list.size() - 1;
			}
		}
		
		System.out.println(list);
		System.out.println(counter);
		
		
		
		
		
		
		
		
	}
}