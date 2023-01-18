package dto;

public class Account2 {
	private String name;
	private int age;
	private String gender;
	private String number;
	private String mail;
	public Account2(String name, int age, String gender, String number, String mail) {
		// TODO 自動生成されたコンストラクター・スタブ
		super();
		this.gender=gender;
		this.age=age;
		this.number=number;
		this.name = name;
		this.mail = mail;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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
}
