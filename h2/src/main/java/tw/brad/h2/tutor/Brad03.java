package tw.brad.h2.tutor;

import java.util.List;

import org.hibernate.Session;

import tw.brad.h2.entity.Employee;
import tw.brad.h2.utils.HibernateUtil;

public class Brad03 {
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String sql = """
				SELECT EmployeeID, FirstName, LastName, Title
				FROM employees
				ORDER BY Title ASC
				""";
			List<Employee> employees = 
				session.createNativeQuery(sql, Employee.class).getResultList();
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