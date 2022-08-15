package Model;

public class mPosition {
	private String maCV;
	private String tenCV;
	public mPosition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaCV() {
		return maCV;
	}
	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}
	public String getTenCV() {
		return tenCV;
	}
	public void setTenCV(String tenCV) {
		this.tenCV = tenCV;
	}
	public mPosition(String maCV, String tenCV) {
		super();
		this.maCV = maCV;
		this.tenCV = tenCV;
	}
	@Override
	public String toString() {
		return "mPosition [maCV=" + maCV + ", tenCV=" + tenCV + "]";
	}
	
}
