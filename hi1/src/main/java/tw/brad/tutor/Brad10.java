package tw.brad.tutor;

import tw.brad.service.OrderService;
import tw.brad.service.OrderServiceImp;

public class Brad10 {

	public static void main(String[] args) {
		OrderService service = new OrderServiceImp();
		
		Long id = service.createOrder("mary");
		System.out.println(id);
		
		service.addItems(id, "ETH", 20, 7);
		service.addItems(id, "Ball", 40, 5);
		
		
		
	}

}