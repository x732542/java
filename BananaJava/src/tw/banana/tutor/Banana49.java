package tw.banana.tutor;

import java.io.File;
import java.io.FileInputStream;

public class Banana49 {
	public static void main(String[] args) {
		File file = new File("dir1/file3.txt");
		try (FileInputStream fin = new FileInputStream(file);) {
			long len = file.length();
			byte[] buf = new byte[(int)len]; 
			while ((len = fin.read(buf)) != -1) {
				System.out.print(new String(buf));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}