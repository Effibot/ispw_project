package logic.bean;

public class LoginBean {
	
	public LoginBean(String usrname, String pword) {
		username = usrname;
		password = pword;
	}
	
	private String password;
	private String username;
	private int id;
	private boolean type = false;
	
	public boolean getType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
