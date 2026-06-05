package tw.brad.tutor;

public class Jdbc01 {
	public static void main(String[] args) {
		// Load Driver =>Connector
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("oktw.brad.apis");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
