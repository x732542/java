package tw.banana.tutor;

import java.util.ArrayList;
import java.util.List;

public class Banana36 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add(0,"Brad");
		list.add(0,"Andy");
		list.add(0,"Peter");
		list.add(0,"Tony");
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(2));
		list.remove(2);
		System.out.println(list);
		
		
	}
}