package tw.brad.tutor;

import java.util.List;

import tw.brad.dao.TestDao;
import tw.brad.entity.Test;

public class Brad05 {

	public static void main(String[] args) {
		TestDao dao = new TestDao();
		Test test = new Test();
		test.setCname("brad3");
		test.setTel("222");
		test.setBirthday("1999-03-04");
		//dao.addTest(test);
		
		Test t2 = dao.findById(15);
		if (t2 != null) {
			System.out.println(t2.getId());
			System.out.println(t2.getCname());
			System.out.println(t2.getTel());
			System.out.println(t2.getBirthday());
			t2.setCname("newAAA");
			//dao.updateTest(t2);
			//dao.delTest(t2);
		}
		System.out.println("---");
		List<Test> tests = dao.findAll();
		for (Test tt: tests) {
			System.out.println(tt.getCname());
		}
		
		
	}

}