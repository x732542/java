package tw.brad.h2.tutor;

import java.util.List;

import org.hibernate.Session;

import tw.brad.h2.entity.Employee;
import tw.brad.h2.utils.HibernateUtil;

public class Brad06 {
	public static void main(String[] args) {
		System.out.println("Brad06");
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = """
					FROM Employee e
					ORDER BY e.title ASC, e.lastName DESC  
				""";
			List<Employee> employees = 
				session.createQuery(hql, Employee.class).getResultList();
			System.out.println(employees.size());
			for (Employee e : employees) {
				System.out.printf("%d:%s:%s:%s\n",
						e.getEmployeeId(),
						e.getFirstName(),
						e.getLastName(),
						e.getTitle());
			}
			
			
		}		
	}
}