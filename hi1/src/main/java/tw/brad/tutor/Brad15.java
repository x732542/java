
package tw.brad.tutor;

import tw.brad.dao.SCDao;
import tw.brad.entity.Course;
import tw.brad.entity.Student;

public class Brad15 {

	public static void main(String[] args) {
		SCDao dao = new SCDao();
		
		dao.save(new Course("Java"));
		dao.save(new Course("JDBC"));
		dao.save(new Course("Tomcat"));
		dao.save(new Course("Hibernate"));
		dao.save(new Course("Spring"));
		
	}

}