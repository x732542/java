package tw.brad.tutor;

import tw.brad.dao.MemberDao;
import tw.brad.entity.Member;
import tw.brad.entity.MemberInfo;

public class Brad07 {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		Member member = dao.findById(1);
		System.out.println(member.getAccount());
		
		if (member != null) {
			MemberInfo info = member.getMemberinfo();
			if (info != null) {
				System.out.printf("MemberInfo: %s\n", info.getBirthday());
				info.setBirthday("2000-01-02");
			}else {
				info = new MemberInfo();
				info.setBirthday("1999-03-04");
				info.setMale(false);
				info.setTel("333");
				member.setMemberinfo(info);
			}
			dao.updateMember(member);
		}else {
			System.out.println("Member ID NOT EXIST");
		}
		
		
		
		
	}
}