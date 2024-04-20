package in.ineuron.dto;

public class Customer {
	private int cid;
	private String cname;
	private String cemail;
	private String cpassword;
	private String caddress;
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String password) {
		this.cpassword = password;
	}
	
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cpassword=" + cpassword
				+ ", caddress=" + caddress + "]";
	}

	
}
