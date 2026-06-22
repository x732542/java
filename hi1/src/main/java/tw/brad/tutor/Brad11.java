package tw.brad.tutor;

import tw.brad.service.OrderService;
import tw.brad.service.OrderServiceImp;

public class Brad11 {

	public static void main(String[] args) {
		OrderService service = new OrderServiceImp();
		
		service.addItems(1L, "item1", 100, 2);
		service.addItems(1L, "item2", 120, 3);
		service.addItems(1L, "item3", 105, 5);
		
	}

}