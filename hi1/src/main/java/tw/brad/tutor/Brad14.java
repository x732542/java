package tw.brad.tutor;

import tw.brad.dao.SCDao;
import tw.brad.entity.Student;

public class Brad14 {

	public static void main(String[] args) {
		SCDao dao = new SCDao();
		
		dao.save(new Student("brad"));
		dao.save(new Student("eric"));
		dao.save(new Student("tony"));
		dao.save(new Student("mark"));
		
	}

}