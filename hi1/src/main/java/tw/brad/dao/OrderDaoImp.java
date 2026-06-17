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
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void delete(Session session, Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> findAll(Session session, Order order, int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
