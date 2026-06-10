package tw.brad.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tw.brad.apis.Food;

public class FoodDao {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL_QUERY_ALL = """
			SELECT id, name, addr, tel, city, town, picurl
			FROM food
			ORDER BY id
			LIMIT ?,?
			""";
	private int page, rpp;

	public FoodDao() {
	}

	public FoodDao(int page, int rpp) {
		this.page = page;
		this.rpp = rpp;
	}

	public List<Food> query() {
		List<Food> foods = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
				PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY_ALL)) {
			pstmt.setInt(1, (page - 1) * rpp);
			pstmt.setInt(2, rpp);
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					Food food = new Food();
					food.setId(rs.getLong("id"));
					food.setName(rs.getString("name"));
					food.setAddr(rs.getString("addr"));
					food.setTel(rs.getString("tel"));
					food.setCity(rs.getString("city"));
					food.setTown(rs.getString("town"));
					food.setPicurl(rs.getString("picurl"));
				foods.add(food);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return foods;
	}
}
