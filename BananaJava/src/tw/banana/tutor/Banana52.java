package tw.banana.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Banana52 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try (FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
				FileOutputStream fout = new FileOutputStream("dir2/coffee1.jpg")) {
			int len;
			byte[] buf = new byte[4 * 1024];
			while ((len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			System.out.println("Finish1");
			System.out.println(System.currentTimeMillis() - start);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
