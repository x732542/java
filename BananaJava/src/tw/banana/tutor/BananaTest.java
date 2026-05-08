package tw.banana.tutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random; 

/*
 
使用陣列 先從順時針開始數，當數到第一個水手(O)時，將此去除後轉換方向，換成逆時針開始數，
之後以此類推。
規則如下：
由input.txt檔案讀取字串 **忽略** 改為亂數產生
字串內容為隨機的O與X組合 (注意：O與X的數量皆不固定)

1.將字串的頭尾鏈結起來(圍成一個圓形)
2.並計算一個神奇數字 **未定義神奇數字 

--參考約瑟夫問題 假定情況 
    神奇數字為原始字串長度

3.從字串的頭開始數
4.數到神奇數字時將該字元去除
5.去除該字元後，依照這次的方向規定重複步驟4

*/


public class BananaTest {
    public static void main(String[] args) {
        //實驗階段 直接產生結果
    
        //以下為隨機情況 --ai
        // -------------
        //random 是util 裡的 類別
        // Random random = new Random();
        // int length = random.nextInt(8) + 8;
        // //單一序列 用StringBuilder 效能更好 嗎?
        // StringBuilder builder = new StringBuilder();
        // for (int i = 0; i < length; i++) {
        //     builder.append(random.nextBoolean() ? 'o' : 'x');
        // }
        // String input = builder.toString();
        // // -------------
        
        //以下字串為固定情況
        //----------------
        String input = "oooooooo";
        //----------------

        //將上述內容拆為字元
        char[] chars = input.toCharArray();

        //初始化list 轉型為Character
        List<Character> list = new ArrayList<>();
        //for each 尋訪 chars 將全部元素放入list
        for (char c : chars) list.add(c);

        int index = 0;   // 索引 預設值為0 從list第一個元素開始尋訪
        int dir = 1;     // 前進方向    1 : 順; -1 : 逆
        int counter = 0; // 移除 o 的總次數

        // while 迴圈 為符合題意 先將水手(o)清除 
        // 第一次迴圈 資料整理
        while (list.contains('o')) {
            //紀錄迴轉次數
            char current = list.get(index);

            //檢查 當前元素是否為o
            if (current == 'o') {
                //如果是 移除
                list.remove(index);
                //如果list是空的 跳出迴圈
                if (list.isEmpty()) break;
                
            //以下方法為    Math.floorMod()雛形 基於list.size特性 不會有負數結果 可以正常使用
                //前進方向
                dir *= -1;

                //目標位置 = (現在位置+字串長度+前進方向) % 字串長度
                //            (0+12+1)%12 = 13%12 → 商1餘1 → index=1  順時鐘前進一步
                //                                  從[0] 前往 [1]
                //            (3+11-1)%11 = 13%11 → 商1餘2 → index=2  逆時鐘前進一步
                //                                  從[3] 前往 [2]
                //             餘數為目的地
                index = (index + list.size() + dir) % list.size();
                counter++;
            }else {
                index = (index + list.size() + dir) % list.size();
            }
        }

            //// 上課原版
            ////當list內包含x時
        	// while (list.contains('x')) {
            ////紀錄迴轉次數
			// char current = list.get(index);
			
			////如果當前位置元素為x
			// if (current == 'x') 
            ////移除該元素
			// 	list.remove(index);
            ////若list為空 跳出
			// 	if (list.isEmpty()) break;
			
            ////更換行徑方向
			// 	dir *= -1;
			// 	index += dir;
            ////記錄總迴轉次數
			// 	counter++;}

            ////倘若該元素不為x 則繼續尋訪
            //     else {index += dir;}

            ////鐘擺 當x想移動到list最大長度外時 移動[0]位置
			// if (index >= list.size()) {index = 0;}
            ////當x想移動到[0]時 移動到最後一位
            //     else if (index < 0) {index = list.size() - 1;}
            // }

        System.out.printf("第一層結束後 list: %s", list);
        System.out.printf("移除水手:%d%n", counter);

        // 預防極端值-全X
        if (list.isEmpty()) {
            System.out.println("無倖存者");
            return;
        }

        // 記錄第一層結束後的快照 用來查詢倖存者原始位置
        // 改用位置索引清單追蹤 避免 indexOf 因元素相同無法分辨的問題
        List<Integer> posList = new ArrayList<>(); //初始化        
        for (int i = 0; i < list.size(); i++) posList.add(i);

        // **第二次迴圈 真。約瑟夫問題**

        // 重設方向為 順時針
        dir = 1;
        // 神奇數字 = 原始字串長度
        int magicNumber = input.length();
        System.out.printf("輸入字串: %s 魔法數字為: %d%n", input, magicNumber);
        int step = 0; // 目前數到第幾步

        while (posList.size() > 1) {
            // 每走一步 step +1
            step++;

            // 數到神奇數字時 移除當前位置
            if (step == magicNumber) {
                posList.remove(index);
                step = 0; // 重置步數

                // 移除後若只剩一人 跳出
                if (posList.isEmpty()) break;

                // 移除後 index 修正（環形）
                index = index % posList.size();
            } else {
                // 尚未數到神奇數字 繼續前進
                index = (index + posList.size() + dir) % posList.size();
            }
        }

        // 在哪個位置能存活
        int live = posList.get(0);
        System.out.println("最終倖存者 : [" + live + "]");



    }
}