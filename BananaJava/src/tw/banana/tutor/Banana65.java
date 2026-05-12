package tw.banana.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpConnectTimeoutException;

public class Banana65 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.fortinet.com/tw/resources/cyberglossary/tcp-ip");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());

			byte[] buf = bin.readAllBytes();
			
			BufferedOutputStream  bout = new BufferedOutputStream(new FileOutputStream("dir2/aaaa.jpg"));
			bout.write(buf);					
			bout.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
