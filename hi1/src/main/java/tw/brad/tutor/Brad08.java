package tw.brad.tutor;

import java.util.List;

import tw.brad.dao.MemberDao;
import tw.brad.entity.Member;
import tw.brad.entity.MemberInfo;

public class Brad08 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		List<Member> members = dao.findByAccountLike("a");
		for (Member member : members) {
			System.out.printf("%s:\n", member.getAccount());
			MemberInfo info = member.getMemberinfo();
			if (info != null) {
				System.out.printf("%s:%s:%s\n", 
						info.getTel(),
						info.getBirthday(),
						info.isMale()?"男":"女");
			}
			System.out.println("----");
		}
	}

}