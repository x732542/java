package com.example.spring1.apis;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring1.dto.Order;
import com.example.spring1.dto.OrderDetail;

@RestController
@RequestMapping("/north")
public class Brad11 {

	@Autowired
	@Qualifier("northJdbc")
	private NamedParameterJdbcTemplate jdbc;
	
	@GetMapping("/test1")
	public void test1() {
		String sql = """
				SELECT EmployeeID, LastName,FirstName, Title
				FROM employees
				""";
		List<Map<String,Object>> emplyees = jdbc.queryForList(sql, new HashMap<>());
		System.out.println(emplyees.size());
	}
	
	@GetMapping(value = {"/orders", "/orders/{orderId}"})
	public List<Order> test2(@PathVariable(required = false) Integer orderId) {
		boolean isOrderId = orderId != null;
		HashMap<String, Integer> params = new HashMap<>();
		
		String sql = """
				SELECT o.OrderID id, o.OrderDate odate,
					p.ProductName pname, 
					od.UnitPrice price, od.Quantity qty
				FROM orders o
				JOIN orderdetails od ON o.OrderID = od.OrderID
				JOIN products p ON od.ProductID = p.ProductID
				""";
		if (isOrderId) {
			sql += " WHERE o.OrderID = :orderId";	
			params.put("orderId", orderId);
		}
		
		List<Order> orders = new ArrayList<>();
		
		List<Map<String,Object>> details = jdbc.queryForList(sql, params);
		
//		Order order = new Order();
//		order.setOrderId((Integer)details.get(0).get("id"));
//		order.setOrderDate(((LocalDateTime)(details.get(0).get("odate"))).toString());
		
		int nowOrderId = 0; Order order = null;
		for (Map<String,Object> detail: details) {
			int oid = (Integer)detail.get("id");
			if (oid != nowOrderId) {
				order = new Order();
				order.setOrderId(oid);
				order.setOrderDate(((LocalDateTime)(detail.get("odate"))).toString());
				orders.add(order);
				nowOrderId = oid;
			}
			OrderDetail od = new OrderDetail();
			od.setId((Integer)detail.get("id"));
			od.setPname((String)detail.get("pname"));
			od.setPrice(Double.parseDouble(detail.get("price").toString()));
			od.setQty(Integer.parseInt(detail.get("qty").toString()));
			order.getDetails().add(od);
		}
		
		
		
		return orders;
		
	}
	
}