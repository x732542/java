package tw.brad.tutor;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import tw.brad.dao.SCDao;
import tw.brad.entity.Course;
import tw.brad.entity.Student;

public class Brad16 {

	public static void main(String[] args) {
		SCDao dao = new SCDao();
		
		Student s1;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Student ID: ");
		long sid = scanner.nextLong();
		
		s1 = dao.getStudentById(sid);
		if (s1 != null) {
			System.out.printf("Welcome, %s\n", s1.getSname());

			while (true) {
				System.out.println("----Course List-----");
				List<Course> courses = dao.getAllCourse();
				for (Course course : courses ) {
					if (!isExist(s1, course.getStudents())) {
						System.out.printf("%d: %s\n", course.getCid(), course.getCname());
					}
				}
				System.out.println("---");
				System.out.print("Which? (0: Quit)");
				long cid = scanner.nextLong();
				
				if (cid == 0) break;
				s1.addCourse(dao.getCourseById(cid));
				s1 = dao.update(s1);
			}
		}else {
			System.out.println("ID NOT EXIST");
		}
	}
	
	static boolean isExist(Student s, Set<Student> students) {
		return students.stream().anyMatch(student -> student.getSid().equals(s.getSid()));
	}
	

}