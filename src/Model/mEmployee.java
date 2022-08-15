package Model;

public class mEmployee {
	private int id;
	private String fullName;
	private String birthDay;
	private String gender;
	private String email;
	private int passPort;
	private int phone;
	private String homeTowm;
	private String position;
	public mEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mEmployee(int id, String fullName, String birthDay, String gender, String email, int passPort, int phone,
			String homeTowm, String position) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.birthDay = birthDay; 
		this.gender = gender;
		this.email = email;
		this.passPort = passPort;
		this.phone = phone;
		this.homeTowm = homeTowm;
		this.position = position;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPassPort() {
		return passPort;
	}
	public void setPassPort(int passPort) {
		this.passPort = passPort;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getHomeTowm() {
		return homeTowm;
	}
	public void setHomeTowm(String homeTowm) {
		this.homeTowm = homeTowm;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "mEmployee [id=" + id + ", fullName=" + fullName + ", birthDay=" + birthDay + ", gender=" + gender
				+ ", email=" + email + ", passPort=" + passPort + ", phone=" + phone + ", homeTowm=" + homeTowm
				+ ", position=" + position + "]";
	}

	
}
