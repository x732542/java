package tw.brad.tutor;

import tw.brad.apis.BCrypt;

public class Jdbc15 {
	public static void main(String[] args) {
		String input = "123456";
		String passwd = "$2a$10$MQqWQBEz2HyAjFrsvqKtZ.V9Y9mhSYX1LHhcJvbnPxHRbxLlfp05u";

		if (BCrypt.checkpw(input, passwd)) {
			System.out.println("ok");
		} else {
			System.out.println("no");

		}

	}
}