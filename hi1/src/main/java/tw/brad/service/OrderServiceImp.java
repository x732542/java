package tw.brad.service;

import java.util.List;

import tw.brad.entity.Order;
import tw.brad.entity.OrderItem;

public class OrderServiceImp implements OrderService{

	@Override
	public Long createOrder(String customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long createOrderWithItems(String customer, List<OrderItem> items) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeCustomerName(Long orderId, String newName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItems(Long orderId, String pname, int price, int qty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItemQty(Long orderId, Long itemId, int newqQty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long orderId, Long itemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order getOrderWithItems(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Long orderId) {
		// TODO Auto-generated method stub
		
	}

}
