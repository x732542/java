package tw.brad.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.dao.OrderDao;
import tw.brad.dao.OrderDaoImp;
import tw.brad.entity.Order;
import tw.brad.entity.OrderItem;
import tw.brad.utils.HibernateUtil;

public class OrderServiceImp implements OrderService{
	private OrderDao dao = new OrderDaoImp();
	
	@Override
	public Long createOrder(String customer) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = new Order();
			order.setCustomer(customer);
			Long id = dao.save(session, order);
			
			transaction.commit();
			return id;
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
		return -1L;
	}

	@Override
	public Long createOrderWithItems(String customer, List<OrderItem> items) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = new Order();
			order.setCustomer(customer);
			
			for (OrderItem item: items) {
				order.addItem(item);
			}
			
			Long id = dao.save(session, order);
			
			transaction.commit();
			return id;
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
		return -1L;
	}

	@Override
	public void changeCustomerName(Long orderId, String newName) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findById(session, orderId)
					.orElseThrow(() -> new IllegalArgumentException("訂單找不到"));
			order.setCustomer(newName);
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	@Override
	public void addItems(Long orderId, String pname, int price, int qty) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findById(session, orderId)
					.orElseThrow(() -> new IllegalArgumentException("訂單找不到"));
			order.addItem(new OrderItem(pname, price, qty));
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}		
	}

	@Override
	public void updateItemQty(Long orderId, Long itemId, int newQty) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findByIdWithItems(session, orderId)
					.orElseThrow(() -> new IllegalArgumentException("訂單找不到"));

//			boolean isFind = false;
//			List<OrderItem> items = order.getItems();
//			for (OrderItem item: items) {
//				if (item.getId().equals(itemId) ) {
//					isFind = true;
//					item.setQty(newQty);
//					break;
//				}
//			}
//			if (!isFind) throw new IllegalArgumentException("品項找不到");
			
			OrderItem item = order.getItems().stream()
				.filter(i -> i.getId().equals(itemId) )
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("品項找不到"));
			item.setQty(newQty);
			/*
			 * .stream() 之後
			 * 期間操作
			 * filter()
			 * map()
			 * sorted()
			 * limit()
			 * 
			 * 收尾操作
			 * findFirst()
			 * toList()
			 * sum()
			 * count()
			 * forEach()
			 * 
			 */
			
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}		
	}

	@Override
	public void removeItem(Long orderId, Long itemId) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findByIdWithItems(session, orderId)
					.orElseThrow(() -> new IllegalArgumentException("訂單找不到"));
			
			OrderItem item = order.getItems().stream()
				.filter(i -> i.getId().equals(itemId))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("品項找不到"));
			order.removeItem(item);
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}				
	}

	@Override
	public Order getOrderWithItems(Long orderId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return dao.findByIdWithItems(session, orderId)
					.orElseThrow(() -> new IllegalArgumentException("訂單找不到"));
		}			
	}

	@Override
	public void deleteOrder(Long orderId) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findByIdWithItems(session, orderId)
					.orElseThrow(() -> new IllegalArgumentException("訂單找不到"));
			
			dao.delete(session, order);
			
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}				
		
	}

	public Order getOrderById(Long orderId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return dao.findById(session, orderId)
					.orElseThrow(() -> new IllegalArgumentException("訂單找不到"));
		}			
	}

	public void test1(Long orderId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Order order = dao.findById(session, orderId)
					.orElseThrow(() -> new IllegalArgumentException("訂單找不到"));
	 		List<OrderItem> items = order.getItems();
	 		for (OrderItem item : items) {
	 			System.out.println(item.getPname());
	 		}
			
			
		}			
	}
	
	
}