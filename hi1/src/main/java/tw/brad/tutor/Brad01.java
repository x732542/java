package tw.brad.tutor;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.utils.HibernateUtil;

public class Brad01 {

	public static void main(String[] args) {
 		try (Session session = HibernateUtil.getSessionFactory().openSession();){
  			Transaction transaction = session.beginTransaction();
  			
  			String sql = """
  					INSERT INTO test
  						(cname,tel,birthday)
  					VALUES
  						(:cname,:tel,:birthday)
  					""";
  			NativeQuery query = session.createNativeQuery(sql);
  			query.setParameter("cname", "brad1");
  			query.setParameter("tel", "111");
  			query.setParameter("birthday", "1999-01-02");
  			
  			int n = query.executeUpdate();
  			System.out.println(n);
  			
  			transaction.commit();
 		}
	}

}