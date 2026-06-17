package tw.brad.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String account;
	
	private String passwd;
	
	private byte[] icon;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}
	//------------------------------
	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private MemberInfo memberinfo;

	public MemberInfo getMemberinfo() {
		return memberinfo;
	}

	public void setMemberinfo(MemberInfo memberinfo) {
		this.memberinfo = memberinfo;
		memberinfo.setMember(this);
	}
	
	
	
}