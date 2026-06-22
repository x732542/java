package tw.brad.tutor;

import java.util.List;

import tw.brad.entity.Order;
import tw.brad.entity.OrderItem;
import tw.brad.service.OrderService;
import tw.brad.service.OrderServiceImp;

public class Brad12 {

	public static void main(String[] args) {
		OrderService service = new OrderServiceImp();
		
		Order order = service.getOrderWithItems(1L);
 		List<OrderItem> items = order.getItems();
 		for (OrderItem item : items) {
 			System.out.println(item.getPname());
 		}
 		
 		
		
	}

}