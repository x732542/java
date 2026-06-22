package tw.brad.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import tw.brad.entity.Order;

public class OrderDaoImp implements OrderDao{

	@Override
	public Long save(Session session, Order order) {
		session.persist(order);
		return order.getId();
	}

	@Override
	public Optional<Order> findById(Session session, Long id) {
		Order order = session.get(Order.class, id);
		return Optional.ofNullable(order);
	}

	@Override
	public Optional<Order> findByIdWithItems(Session session, Long id) {
		// LEFT JOIN
		String hql = """
				SELECT o
				FROM Order o
				LEFT JOIN FETCH o.items
				WHERE o.id = :id
				""";
		Order order =session.createQuery(hql, Order.class)
				.setParameter("id", id)
				.uniqueResult();
		return Optional.ofNullable(order);
	}

	@Override
	public void delete(Session session, Order order) {
		session.remove(order);
	}

	@Override
	public List<Order> findAll(Session session, Order order, int start, int size) {
		String hql = """
				SELECT o
				FROM Order o
				ORDER BY o.id DESC
				""";
		return session.createQuery(hql, Order.class)
				.setFirstResult(start)
				.setMaxResults(size)
				.list();
	}
	//--------------------------
	public List<Order> test1(Session session, String cname) {
		String hql = """
				SELECT o
				FROM Order o
				WHERE o.customer = :cname
				""";
		return session.createQuery(hql, Order.class).setParameter("cname", cname).list();
	}
	
	public List<Order> test2(Session session) {
		String hql = """
				SELECT o
				FROM Order o
				ORDER BY o.odate
				""";
		return session.createQuery(hql, Order.class).list();
	}
	
	public void test3() {
		String hql = """
				SELECT o
				FROM Order o
				JOIN o.items i
				WHERE i.pname = :pname
				ORDER BY o.id
				""";		
	}
	
	
	
}