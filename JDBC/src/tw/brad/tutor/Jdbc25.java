package tw.brad.tutor;

import java.util.List;

import tw.brad.apis.Member;
import tw.brad.apis.MemberDao;
import tw.brad.apis.MemberDaoImpl;

public class Jdbc25 {
	public static void main(String[] args) {
		String account = "Candy", passwd = "123456";
		MemberDao dao = new MemberDaoImpl();
		
		Member member = new Member();
		member.setAccount(account); member.setPasswd(passwd);
		try {
			if (dao.addMember(member)) {
				System.out.println("OK");
			}else {
				System.out.println("XX");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		//------------------
		try {
			Member member1 = dao.findById(2);
			member1.setPasswd("654321");
			if (dao.updateMember(member1)) {
				System.out.println("OK1");
			}else {
				System.out.println("XX1");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		//------------------
		try {
			Member member2 = dao.login("eric", "654321");
			if (member2 != null) {
				System.out.println("Login Success");
			}else {
				System.out.println("Login Failure");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		//-----------------
		try {
			List<Member> members = dao.findAll();
			for (Member mm: members) {
				System.out.println(mm.getAccount());
			}
		} catch (Exception e) {
		}
		
		
		
		
		
	}
}