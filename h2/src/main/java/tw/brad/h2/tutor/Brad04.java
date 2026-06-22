package tw.brad.h2.tutor;

import java.util.List;

import org.hibernate.Session;

import tw.brad.h2.entity.Employee;
import tw.brad.h2.utils.HibernateUtil;

public class Brad04 {
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String sql = """
					SELECT EmployeeID, FirstName, LastName, Title
					FROM employees
					ORDER BY Title ASC
					""";
			List<Object[]> employees = 
					session.createNativeQuery(sql, Object[].class).getResultList();
			System.out.println(employees.size());
			for (Object[] e : employees) {
				System.out.printf("%d:%s:%s:%s\n",
						e[0],
						e[1],
						e[2],
						e[3]);
			}
		}
	}
}
