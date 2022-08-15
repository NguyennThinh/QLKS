package Model;

public class mService {
	private int id;
	private String serviceName;
	private String serviceType;
	private int servicePrice;
	private String unit;
	public mService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mService(int id, String serviceName, String serviceType, int servicePrice, String unit) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.servicePrice = servicePrice;
		this.unit = unit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public int getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(int servicePrice) {
		this.servicePrice = servicePrice;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "mService [id=" + id + ", serviceName=" + serviceName + ", serviceType=" + serviceType
				+ ", servicePrice=" + servicePrice + ", unit=" + unit + "]";
	}
	
	
}
