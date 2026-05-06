package tw.banana.tutor;

import java.util.*;

import tw.Ban.apis.Bike;

public class Banana34 {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("Brad");
		set.add(new Bike());
		set.add(123);	// int -> auto-boxing -> Integer
		set.add(12.3);	// double -> auto-boxing -> Double
		set.add("Brad");
		System.out.println(set.size());
		System.out.println(set);
		
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		System.out.println("----");
		for (Object obj: set) {
			System.out.println(obj);
		}
		
	}
}