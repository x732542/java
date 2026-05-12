package tw.banana.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpConnectTimeoutException;

public class Banana64 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.pchome.com.tw/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
