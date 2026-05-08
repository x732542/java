package tw.banana.tutor;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Banana40 {

	public static void main(String[] args) {
		List<String> list = List.of("A","B","C","D","E");
		System.out.println(list.get(0));
		Set<String> set = Set.of("A","B","C","D","E");
		for(String name:set) System.out.println(name);
		System.out.println("--------");
		Map<Integer,String> map = Map.of(1, "Aa",2, "Bb",3, "Cc");
		System.out.println(map.get(2));
	}

}
