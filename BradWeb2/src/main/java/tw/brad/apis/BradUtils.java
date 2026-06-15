package tw.brad.apis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BradUtils {
	public static String calc(String x, String y) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			return (intX + intY) + "";
		}catch(Exception e) {
			return "";
		}
	}
	public static String loadView() throws Exception {
		String source = "C:\\Users\\User\\git\\repository\\BradWeb2\\src\\main\\webapp\\views\\view1.html";
		File html = new File(source);
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(html));
		byte[] data = bin.readAllBytes();
		bin.close();
		return new String(data);
	}

	public static String loadView(String view) throws Exception {
		String source = 
			String.format("C:\\Users\\User\\git\\repository\\BradWeb2\\src\\main\\webapp\\views\\%s.html", view);
		Path path = Path.of(source);
		return  Files.readString(path);
	}
	
	
}