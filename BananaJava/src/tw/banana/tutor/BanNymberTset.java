package tw.banana.tutor;

public class BanNymberTset {

	// 定義雙向環狀鏈結串列的節點結構
	static class Node {
		char data;   // 儲存字元資料 ('O' 或 'X')
		Node prev;   // 指向前一個節點
		Node next;   // 指向後一個節點

		// 建構子：初始化節點資料，prev/next 預設為 null
		Node(char data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		String input = "O1OOO3O4"; // 輸入字串，代表圍成圓圈的水手序列

		// 步驟 1：將字串轉為雙向環狀鏈結串列（首尾相連）
		Node head = createCircularList(input);

		// 步驟 2：計算「神奇數字」= 串列長度（即字串字元數）
		int magicNumber = countMagicNum(head);
		System.out.println("神奇數字為 " + magicNumber);

		// 步驟 3：依序移除節點，直到只剩最後一個
		Node lastNode = removeNodes(head, magicNumber);

		// 輸出最後倖存的字元
		System.out.println("最後剩下的字元是: " + lastNode.data);
	}

	// 建立雙向環狀鏈結串列
	// 修正：先建立 head 節點，再從第二個字元開始 loop，避免靜態分析誤判 tail 為 null
	static Node createCircularList(String str) {
		if (str == null || str.isEmpty())
			return null; // 空字串直接回傳 null

		char[] chars = str.toCharArray();

		// 用第一個字元建立 head，tail 初始也指向 head
		Node head = new Node(chars[0]);
		Node tail = head;

		// 從第二個字元開始，逐一建立節點並接到串列尾端
		for (int i = 1; i < chars.length; i++) {
			Node newNode = new Node(chars[i]);
			tail.next = newNode;    // 目前尾端的 next 指向新節點
			newNode.prev = tail;    // 新節點的 prev 指回目前尾端
			tail = newNode;         // 更新 tail 為新節點
		}

		// 首尾相連，形成環狀結構
		tail.next = head;  // 最後節點的 next 指向頭
		head.prev = tail;  // 頭節點的 prev 指向最後節點

		return head;
	}

	// 計算環狀串列的節點總數（即「神奇數字」）
	// 使用 do-while 確保至少走訪一次 head，避免誤判空串列
	static int countMagicNum(Node head) {
		if (head == null)
			return 0;
		int count = 0;
		Node current = head;
		do {
			count++;               // 每走訪一個節點就計數 +1
			current = current.next; // 移動到下一個節點
		} while (current != head); // 回到 head 代表繞完一圈
		return count;
	}

	// 依「約瑟夫問題」邏輯，每次數 magicNumber 步後移除節點
	static Node removeNodes(Node head, int magicNumber) {
		// 若串列為空或只剩一個節點（自己指向自己），直接回傳
		if (head == null || head.next == head)
			return head;

		Node current = head; // 從 head 開始

		// 當串列還剩超過一個節點時持續執行
		while (current.next != current) {

			// 向前移動 magicNumber - 1 步，到達要刪除的節點
			for (int i = 0; i < magicNumber - 1; i++) {
				current = current.next;
			}

			// 執行刪除：讓前後節點互相連接，繞過 toDelete
			Node toDelete = current;
			toDelete.prev.next = toDelete.next; // 前節點的 next 跳過 toDelete
			toDelete.next.prev = toDelete.prev; // 後節點的 prev 跳過 toDelete

			// 刪除後，從下一個節點繼續開始數
			current = toDelete.next;
			// Java 有 GC，toDelete 自動被回收，不需要手動 free
		}

		// 迴圈結束時 current 即為唯一倖存節點
		return current;
	}
}
