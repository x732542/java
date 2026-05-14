package tw.banana.tutor;

import java.util.stream.Collectors;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Banana74 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> evens = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(evens);
		
		List<Integer> nums = Arrays.asList(2, 1, 2, 1, 3, 3, 4, 5, 4, 6);
		List<Integer> result = nums.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(result);
		
		List<String> names =Arrays.asList("andy","ban","ana");
		names.stream().forEach(System.out::println);
		boolean isAndy =  names.stream().anyMatch(n->n.equals("ban"));
		System.out.println(isAndy);
		
		
		
	}
}