package tw.brad.tutor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.entity.Test;
import tw.brad.utils.HibernateUtil;

public class Brad03 {

	public static void main(String[] args) {
 		try (Session session = HibernateUtil.getSessionFactory().openSession();){
  			Transaction transaction = session.beginTransaction();
  			
  			String sql = """
  					SELECT * FROM test
  					""";
  			NativeQuery<Test> query = session.createNativeQuery(sql, Test.class);
   			List<Test> list = query.getResultList();
   			for (Test test : list) {
   				System.out.printf("%d:%s:%s:%s\n", 
   						test.getId(),test.getCname(),test.getTel(),test.getBirthday());
   			}
   			
  			transaction.commit();
 		}
	}

}