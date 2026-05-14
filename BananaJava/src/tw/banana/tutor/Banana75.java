package tw.banana.tutor;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Banana75 {
	public static void main(String[] args) {
		List<Integer> numbers = IntStream.range(1, 100).boxed().collect(Collectors.toList());

		List<Integer> primes = numbers.stream().filter(Banana75::isPrime).collect(Collectors.toList());
		System.out.println(primes);
	}
	public static boolean isPrime(int n) {
		if (n == 1)
			return false;
		return IntStream.range(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0);
	}

}