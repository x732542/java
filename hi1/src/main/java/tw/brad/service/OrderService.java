package tw.brad.service;

import java.util.List;

import tw.brad.entity.Order;
import tw.brad.entity.OrderItem;

public interface OrderService {
	Long createOrder(String customer);
	Long createOrderWithItems(String customer,List<OrderItem> items);
	void changeCustomerName(Long orderId,String newName);
	void addItems(Long orderId,String pname,int price, int qty);
	void updateItemQty(Long orderId, Long itemId,int newqQty);
	void remove(Long orderId,Long itemId);
	Order getOrderWithItems(Long orderId);
	void deleteOrder(Long orderId);
}
