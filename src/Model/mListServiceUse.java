package Model;

public class mListServiceUse {
	private int serviceId;
	private String serviceName;
	private int billId;
	private int quantum;
	private int price;
	private String unit;
	public mListServiceUse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mListServiceUse(int serviceId, String serviceName, int billId, int quantum, int price, String unit) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.billId = billId;
		this.quantum = quantum;
		this.price = price;
		this.unit = unit;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "mListServiceUse [serviceId=" + serviceId + ", serviceName=" + serviceName + ", billId=" + billId
				+ ", quantum=" + quantum + ", price=" + price + ", unit=" + unit + "]";
	}

	
	
}
