package tw.banana.tutor;

import java.io.File;

public class Banana45 {
	public static void main(String[] args) {
		File f1 = new File("d:\\dir");
		System.out.println(f1.exists());
		File f2 = new File("d:/banana");
		System.out.println(f2.exists());
		File root = new File(".");
		System.out.println(root.exists());
		System.out.println(root.getAbsolutePath());
		File dir1 = new File("dir1");
		System.out.println(dir1.exists());
	}
}
