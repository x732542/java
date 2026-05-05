package tw.banana.tutor;

import tw.Ban.apis.TWId;

public class Banana28 {

	public static void main(String[] args) {
		System.out.println(TWId.isRight("B123456789"));
			TWId id1 = new TWId();
			TWId id2 = new TWId(true);
			TWId id3 = new TWId('B');
			TWId id4 = new TWId(false,'a');
			System.out.println(id1);
			System.out.println(id2);
			System.out.println(id3);
			System.out.println(id4);
	}

}
