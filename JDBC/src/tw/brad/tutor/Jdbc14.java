package tw.brad.tutor;

import tw.brad.apis.BCrypt;

public class Jdbc14 {
	public static void main(String[] args) {
		String passwd = "123456";
		String hash_passwd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hash_passwd);

		String input= "123456";
		if(BCrypt.checkpw(input,hash_passwd)) {
			System.out.println("ok");
		}else {
			System.out.println("no");
			
		}
		
	}
}