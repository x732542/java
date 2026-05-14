package tw.Ban.apis;

//lombok
public class Member {
	private long id;
	private String name;
	private String passwd;
	private String email;
	private int age;
	
	private Member(Builder build) {
		this.id = build.id;
		this.name = build.name;
		this.passwd = build.passwd;
		this.email = build.email;
		this.age = build.age;
	}
	
	public static class Builder {
		private long id;
		private String name;
		private String passwd;
		private String email;
		private int age;		
		
		public Builder id(long id) {this.id = id; return this;}
		public Builder name(String name) {this.name = name; return this;}
		public Builder passwd(String passwd) {this.passwd = passwd; return this;}
		public Builder email(String email) {this.email = email; return this;}
		public Builder age(int age) {this.age = age; return this;}
		
		public Member build() {
			
			return new Member(this);}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}