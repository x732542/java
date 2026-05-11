package tw.banana.tutor;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.Ban.apis.Bike;

public class Banana56 {
	public static void main(String[] args) {

		try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/b1.bike"));) {
			Object obj = oin.readObject();
			System.out.println("ok");
			Bike b1 =(Bike)obj;
			System.out.println(b1);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
