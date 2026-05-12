package tw.banana.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpConnectTimeoutException;

import org.json.JSONArray;
import org.json.JSONObject;

//public class Banana66 {
//	public static void main(String[] args) {
//		try {
//			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//			String line;
//			StringBuffer sb = new StringBuffer();
//			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
//			}
//			reader.close();
//			parseJSON(sb.toString());
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//	}
//
//	static void parseJSON(String json) {
//		JSONArray root = new JSONArray(json);	
//		System.out.println(root.length());
//		
//		for(int i = 0;i<root.length();i++) {
//			JSONObject gift =  root.getJSONObject(i);
//			String name = gift.getString("Name");
//			System.out.println(name);
//		}
//	}
//}

public class Banana66 {
public static void main(String[] args) {
	try {
		URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
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



static void parseJSON(String json) {
	JSONArray root = new JSONArray(json);
	System.out.println(root.length());
	
	for (int i=0; i<root.length(); i++) {
		JSONObject gift = root.getJSONObject(i);
		String name = gift.getString("Name");
		System.out.println(name);
	}
	
	
}


}
