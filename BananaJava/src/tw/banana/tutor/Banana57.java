package tw.banana.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import tw.Ban.apis.Bike;

public class Banana57 {
	public static void main(String[] args) {
		Student s1 = new Student("Brad", 30, 21, 55);
		System.out.printf("%s:%d:%f\n", s1.getName(), s1.sum(), s1.avg());
		s1.getBike().upSpeed().upSpeed();

		Student s2 = new Student("Andy", 76, 82, 96);
		s2.getBike().upSpeed().upSpeed().upSpeed().upSpeed().downSpeed();
		System.out.printf("%s:%d:%f\n", s2.getName(), s2.sum(), s2.avg());
		try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/s12.student"))) {
			oout.writeObject(s1);
			oout.writeObject(s2);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("----");

		try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/s12.student"))) {
			Student ss1 = (Student) oin.readObject();
			Student ss2 = (Student) oin.readObject();
			System.out.println(ss1.avg());
			System.out.println(ss2.avg());
			System.out.println("----");
			System.out.println(ss1.getBike());
			System.out.println(ss2.getBike());

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

class Student implements Serializable {
	private String name;
	private int ch, eng, math;
	private Bike bike;

	Student(String name, int ch, int eng, int math) {
		this.name = name;
		this.ch = ch;
		this.eng = eng;
		this.math = math;
		bike = new Bike();
	}

	int sum() {
		return ch + eng + math;
	}

	double avg() {
		return sum() / 3.0;
	}

	String getName() {
		return name;
	}

	Bike getBike() {
		return bike;
	}
}