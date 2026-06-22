package tw.brad.h2.tutor;

import java.beans.Customizer;

import org.hibernate.Session;

import tw.brad.h2.entity.Customer;
import tw.brad.h2.utils.HibernateUtil;

public class Brad02 {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Customer c1 = session.get(Customer.class, "BLONP");
			System.out.println(c1.getCname());
		}
	}

}