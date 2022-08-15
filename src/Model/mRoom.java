package Model;

public class mRoom {
	private int id;
	private String roomNumber;
	private String status;
	private String roomType;
	private int amountPeople;
	private int price;
	public mRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mRoom(int id, String roomNumber, String status, String roomType, int amountPeople, int price) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.status = status;
		this.roomType = roomType;
		this.amountPeople = amountPeople;  
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getAmountPeople() {
		return amountPeople;
	}
	public void setAmountPeople(int amountPeople) {
		this.amountPeople = amountPeople;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "mRoom [id=" + id + ", roomNumber=" + roomNumber + ", status=" + status + ", roomType=" + roomType
				+ ", amountPeople=" + amountPeople + ", price=" + price + "]";
	}
	
	
}
