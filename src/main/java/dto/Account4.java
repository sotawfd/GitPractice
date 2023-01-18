package dto;

public class Account4 {
	private String name;
	private String mail;
	private String salt;
	private String password;
	private String hashedPassword;
	
	public Account4(String name, String mail, String salt, String password, String hashedPassword) {
		super();
		this.name = name;
		this.mail = mail;
		this.salt = salt;
		this.password = password;
		this.hashedPassword = hashedPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
}
