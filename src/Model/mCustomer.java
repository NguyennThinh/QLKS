package Model;

import java.sql.Timestamp;

public class mCustomer {
	private String fullName;
	private String grender;
	private String birthDay;
	private int passPort;
	private int phone;
	private String status;
	private String roomNumber;
	private Timestamp dateTimeFrom;
	private Timestamp dateTimeTo;
	private String email;
	public mCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mCustomer(String fullName, String grender, String birthDay, int passPort, int phone, String status,
			String roomNumber, Timestamp dateTimeFrom, Timestamp dateTimeTo, String email) {
		super();
		this.fullName = fullName;
		this.grender = grender;
		this.birthDay = birthDay;
		this.passPort = passPort;
		this.phone = phone;
		this.status = status;
		this.roomNumber = roomNumber;
		this.dateTimeFrom = dateTimeFrom;
		this.dateTimeTo = dateTimeTo;
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGrender() {
		return grender;
	}
	public void setGrender(String grender) {
		this.grender = grender;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Timestamp getDateTimeFrom() {
		return dateTimeFrom;
	}
	public void setDateTimeFrom(Timestamp dateTimeFrom) {
		this.dateTimeFrom = dateTimeFrom;
	}
	public Timestamp getDateTimeTo() {
		return dateTimeTo;
	}
	public void setDateTimeTo(Timestamp dateTimeTo) {
		this.dateTimeTo = dateTimeTo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "mCustomer [fullName=" + fullName + ", grender=" + grender + ", birthDay=" + birthDay + ", passPort="
				+ passPort + ", phone=" + phone + ", status=" + status + ", roomNumber=" + roomNumber
				+ ", dateTimeFrom=" + dateTimeFrom + ", dateTimeTo=" + dateTimeTo + ", email=" + email + "]";
	}
	
}
