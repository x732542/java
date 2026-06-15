package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class Jdbc11 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			HttpURLConnection conn =  (HttpURLConnection)url.openConnection();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			
			String line; StringBuffer sb = new StringBuffer();
			while ( (line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			
			parseJSON(sb.toString());
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	final static String URL = "jdbc:mysql://localhost:3306/brad";
	final static String SQL_DEL_ALL = """
			DELETE FROM food
			""";
	final static String SQL_ONE = """
			ALTER TABLE food AUTO_INCREMENT = 1
			""";
	final static String SQL_INSERT = """
			INSERT INTO food
			(name, tel, addr, feature, city, town, picurl, lat, lng)
			VALUES
			(?,?,?,?,?,?,?,?,?)
			""";	
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		System.out.println(root.length());
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		prop.put("useSSL", false);
		
		try (Connection conn =  DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
				){		
			
			pstmt.execute(SQL_DEL_ALL);
			pstmt.execute(SQL_ONE);
			
			for (int i=0; i<root.length(); i++) {
				
				JSONObject food = root.getJSONObject(i);
				String name = food.getString("Name");
				String tel = food.getString("Tel");
				String addr = food.getString("Address");
				String feature = food.getString("FoodFeature");
				String city = food.getString("City");
				String town = food.getString("Town");
				String picurl = food.getString("PicURL");
				String lat = food.getString("Latitude");
				String lng = food.getString("Longitude");
				
				pstmt.setString(1, name);
				pstmt.setString(2, tel);
				pstmt.setString(3, addr);
				pstmt.setString(4, feature);
				pstmt.setString(5, city);
				pstmt.setString(6, town);
				pstmt.setString(7, picurl);
				
				try {
					pstmt.setDouble(8, Double.parseDouble(lat));
					pstmt.setDouble(9, Double.parseDouble(lng));
				}catch(Exception e) {
					pstmt.setDouble(8, 0.0);
					pstmt.setDouble(9, 0.0);
				}
				
				pstmt.executeUpdate();
			}
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}