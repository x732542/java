package tw.brad.tutor;

import java.util.List;

import tw.brad.entity.OrderItem;
import tw.brad.service.OrderService;
import tw.brad.service.OrderServiceImp;

public class Brad09 {
	public static void main(String[] args) {
		OrderService service = new OrderServiceImp();
		
		//Long id = service.createOrder("brad");
		//System.out.println(id);
		
		List<OrderItem> items = List.of(new OrderItem("BTC", 100, 2),
				new OrderItem("Mouse", 200, 3),
				new OrderItem("NB", 1000, 1));
		Long id2 = service.createOrderWithItems("andy", items);
		
		
	}
}