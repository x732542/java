package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc26 {
	private static final String URL = "jdbc:mysql://localhost:3306/north";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL = """
			SELECT e.Firstname name, SUM(od.UnitPrice*od.Quantity) sum
			FROM `orders` o
			join `employees` e ON o.EmployeeID =e.EmployeeID
			join `orderdetails` od ON od.OrderID = o.OrderID
			GROUP BY o.EmployeeID
			ORDER BY sum DESC
			""";

	private static final String SQL_NANCY = """
			SELECT SUM(od.UnitPrice*od.Quantity) sum
			FROM `Orders` o
			JOIN `oderdetails` od ON o.OrderID = od.OrderID
			WHERE o.EmployeeID = 1  -- 這裡輸入您想驗算的員工編號

									""";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
				PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String sum = rs.getString("sum");
				System.out.printf("%s:%s\n", name, sum);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
