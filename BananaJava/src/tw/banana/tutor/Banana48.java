package tw.banana.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Banana48 {
	public static void main(String[] args) {

		try (FileInputStream fin = new FileInputStream("dir1/file3.txt");) {
			int len;
			byte[] b = new byte[3];
			while ((len = fin.read(b)) != -1) {
				System.out.print(new String(b, 0, len));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
