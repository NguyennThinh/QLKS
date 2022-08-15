package Model;

public class mLogin {
	private int userName;
	private String passWord;
	private String chucVu;
	public mLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mLogin(int userName, String passWord, String chucVu) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.chucVu = chucVu;
	}
	
	public int getUserName() {
		return userName;
	}
	public void setUserName(int userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	@Override
	public String toString() {
		return "mLogin [userName=" + userName + ", passWord=" + passWord + ", chucVu=" + chucVu + "]";
	}
	
	
}
