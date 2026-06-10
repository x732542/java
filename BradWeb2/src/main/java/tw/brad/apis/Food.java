package tw.brad.apis;

public class Food {
	private long id;
	private String name, addr, tel, city, town, picurl;
	public Food() {}
	public Food(long id, String name, String addr, String tel, String city, String town, String picurl) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.city = city;
		this.town = town;
		this.picurl = picurl;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	
	
}
