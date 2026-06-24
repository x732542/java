package com.example.spring1.apis;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brad07")
public class Brad07 {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@RequestMapping("/test1")
	public void test1() {
		String sql = """
				INSERT INTO test
					(cname, tel, birthday)
				VALUES
					(:cname, :tel, :birthday)
				""";
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("cname", "eric1");
		map.put("tel", "111");
		map.put("birthday", "1999-01-02");
		
		int n = jdbc.update(sql, map);
		System.out.println(n);
		
	}
	
}