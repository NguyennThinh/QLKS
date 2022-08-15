package Model;

import java.sql.Timestamp;

public class mBill {
	private int id;
	private String RoomNumber;
	private Timestamp timeFrom;
	private Timestamp timeTo;
	private String status;
	private int totalMoney;
	public mBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mBill(int id, String roomNumber, Timestamp timeFrom, Timestamp timeTo, String status, int totalMoney) {
		super();
		this.id = id;
		RoomNumber = roomNumber;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.status = status;
		this.totalMoney = totalMoney;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomNumber() {
		return RoomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}
	public Timestamp getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(Timestamp timeFrom) {
		this.timeFrom = timeFrom;
	}
	public Timestamp getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(Timestamp timeTo) {
		this.timeTo = timeTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	@Override
	public String toString() {
		return "mBill [id=" + id + ", RoomNumber=" + RoomNumber + ", timeFrom=" + timeFrom + ", timeTo=" + timeTo
				+ ", status=" + status + ", totalMoney=" + totalMoney + "]";
	}
	
	
}
