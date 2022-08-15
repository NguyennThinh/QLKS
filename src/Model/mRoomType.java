package Model;

public class mRoomType {
	private int id;
	private String roomType;
	private int price;
	public mRoomType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mRoomType(int id, String roomType, int price) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "mRoomType [id=" + id + ", roomType=" + roomType + ", price=" + price + "]";
	}
	
	
	
}
