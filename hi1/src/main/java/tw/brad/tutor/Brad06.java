package tw.brad.tutor;

import org.mindrot.jbcrypt.BCrypt;

import tw.brad.dao.MemberDao;
import tw.brad.entity.Member;
import tw.brad.entity.MemberInfo;

public class Brad06 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		Member member = new Member();
		member.setAccount("a1");
		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
		
		MemberInfo info = new MemberInfo();
		info.setBirthday("1999-01-02");
		info.setMale(true);
		info.setTel("123");
		
		member.setMemberinfo(info);
	
		dao.addMember(member);
	}

}
