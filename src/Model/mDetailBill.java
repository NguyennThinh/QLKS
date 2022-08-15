package Model;

public class mDetailBill {
	private int id;
	private int idBill;
	private int idService;
	private int quantum;
	private int price;
	public mDetailBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mDetailBill(int id, int idBill, int idService, int quantum, int price) {
		super();
		this.id = id;
		this.idBill = idBill;
		this.idService = idService;
		this.quantum = quantum;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	public int getQuantum() {
		return quantum;
	}
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "mDetailBill [id=" + id + ", idBill=" + idBill + ", idService=" + idService + ", quantum=" + quantum
				+ ", price=" + price + "]";
	}
	
	
	
}
