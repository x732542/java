package tw.banana.tutor;

import java.util.List;
import java.util.stream.Collectors;

import tw.Ban.apis.Empolyee;

public class Banana76 {
	public static void main(String[] args) {
		Empolyee em1 = new Empolyee("Ban", 30000);
		Empolyee em2 = new Empolyee("Eric", 40000);
		Empolyee em3 = new Empolyee("Mark", 45000);
		Empolyee em4 = new Empolyee("Tony", 70000);
		Empolyee em5 = new Empolyee("Kevin", 60000);
		Empolyee em6 = new Empolyee("John", 55000);
		Empolyee em7 = new Empolyee("Mary", 32000);

		List<Empolyee> employees = List.of(em1, em2, em3, em4, em5, em6, em7);
		List<String> mgrs = employees.stream().filter(e -> e.getSalary() >= 50000).map(Empolyee::getName)
				.collect(Collectors.toList());
		System.out.println(mgrs);

		employees.stream().filter(e -> e.getSalary() >= 50000)
				.forEach(e -> System.out.printf("%s:%d\n", e.getName(), e.getSalary()));

	}
}