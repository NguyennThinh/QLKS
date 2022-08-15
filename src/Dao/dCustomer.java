package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.mCustomer;

public class dCustomer {
	private Connection con;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public dCustomer() {
		con = MyConnection.getConnection();
	}

	public boolean Insert(mCustomer in) {
		String sql = "Insert into KhachHang (hoten, ngaysinh, gioitinh, socmnd,sodienthoai, email ,trangthai, sophong,ngayden,ngaydi) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, in.getFullName());
			ps.setString(2, in.getBirthDay());
			ps.setString(3, in.getGrender());
			ps.setInt(4, in.getPassPort());
			ps.setInt(5, in.getPhone());
			ps.setString(6, in.getEmail());
			ps.setString(7, in.getStatus());
			ps.setString(8, in.getRoomNumber());
			ps.setString(9, df.format(in.getDateTimeFrom()));
			ps.setString(10, df.format(in.getDateTimeTo()));

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra", null, JOptionPane.ERROR_MESSAGE);
		}
		return false;

	}
	public ArrayList<mCustomer> GetAll() {
		ArrayList<mCustomer> arrCus = new ArrayList<mCustomer>();

		String sql = "Select * from KhachHang ";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				mCustomer c = new mCustomer();
				c.setFullName(rs.getString("hoten"));
				c.setGrender(rs.getString("gioitinh"));
				c.setBirthDay(rs.getString("ngaysinh"));
				c.setPassPort(rs.getInt("socmnd"));
				c.setPhone(rs.getInt("sodienthoai"));
				c.setEmail(rs.getString("email"));
				c.setRoomNumber(rs.getString("sophong"));
				c.setStatus(rs.getString("trangthai"));
				c.setDateTimeFrom(rs.getTimestamp("ngayden"));
				c.setDateTimeTo(rs.getTimestamp("ngaydi"));
				arrCus.add(c);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Không thể lấy danh sách khách hàng", null, JOptionPane.ERROR_MESSAGE);
		}

		return arrCus;

	}
	public ArrayList<mCustomer> FindCusByStatus(String Status) {
		ArrayList<mCustomer> arrCus = new ArrayList<mCustomer>();

		String sql = "Select * from KhachHang where trangthai =N'"+Status+"'";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				mCustomer c = new mCustomer();
				c.setFullName(rs.getString("hoten"));
				c.setGrender(rs.getString("gioitinh"));
				c.setBirthDay(rs.getString("ngaysinh"));
				c.setPassPort(rs.getInt("socmnd"));
				c.setPhone(rs.getInt("sodienthoai"));
				c.setEmail(rs.getString("email"));
				c.setRoomNumber(rs.getString("sophong"));
				c.setStatus(rs.getString("trangthai"));
				c.setDateTimeFrom(rs.getTimestamp("ngayden"));
				c.setDateTimeTo(rs.getTimestamp("ngaydi"));
				arrCus.add(c);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Không thể lấy danh sách khách hàng", null, JOptionPane.ERROR_MESSAGE);
		}

		return arrCus;

	}
	public ArrayList<mCustomer> GetAllCustomerByRoom(String Room) {
		ArrayList<mCustomer> arrPhong = new ArrayList<mCustomer>();
		String sql = "Select * from KhachHang where sophong =N'"+Room+"' and trangthai =N'Đang thuê'";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				mCustomer p = new mCustomer();
				p.setFullName(rs.getString("hoten"));
				p.setGrender(rs.getString("gioitinh"));
				p.setBirthDay(rs.getString("ngaysinh"));
				p.setPassPort(rs.getInt("socmnd"));
				p.setStatus(rs.getString("trangthai"));
				p.setRoomNumber(rs.getString("sophong"));
				p.setPhone(rs.getInt("sodienthoai"));
				p.setDateTimeFrom(rs.getTimestamp("ngayden"));
				p.setDateTimeTo(rs.getTimestamp("ngaydi"));
			
				arrPhong.add(p);

			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Không thể lấy danh sách khách hàng", null, JOptionPane.ERROR_MESSAGE);
		}
		return arrPhong;

	}
	public boolean UpdateKhachHang( String RoomNumber, String Status) {

		String sql = "update KhachHang SET  trangthai=N'"+Status+"' where sophong='"+RoomNumber+"' and trangthai=N'Đang thuê'";
		try {
		Statement st =con.createStatement(); 
		return st.executeUpdate(sql)>0;
			
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Không thể cập nhật trạng thái khách hàng", null, JOptionPane.ERROR_MESSAGE);
		}
		return false;

	}
	public boolean UpdateStatusofKhachHang( String RoomNumber, String Status) {

		String sql = "update KhachHang SET  trangthai=N'"+Status+"' where sophong='"+RoomNumber+"' and trangthai=N'Đặt phòng'";
		try {
		Statement st =con.createStatement(); 
		return st.executeUpdate(sql)>0;
			
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Không thể cập nhật trạng thái khách hàng", null, JOptionPane.ERROR_MESSAGE);
		}
		return false;

	}
	public ArrayList<mCustomer> GetCustomer(String Name) {
		ArrayList<mCustomer> arrPhong = new ArrayList<mCustomer>();
		String sql = "select * from KhachHang where hoten LIKE N'%"+Name+"%'";
		 
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				mCustomer p = new mCustomer();
				p.setFullName(rs.getString("hoten"));
				p.setGrender(rs.getString("gioitinh"));
				p.setBirthDay(rs.getString("ngaysinh"));
				p.setPassPort(rs.getInt("socmnd"));
				p.setStatus(rs.getString("trangthai"));
				p.setEmail(rs.getString("email"));
				p.setRoomNumber(rs.getString("sophong"));
				p.setPhone(rs.getInt("sodienthoai"));
				p.setDateTimeFrom(rs.getTimestamp("ngayden"));
				p.setDateTimeTo(rs.getTimestamp("ngaydi"));
			
				arrPhong.add(p);

			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Không thể lấy danh sách khách hàng", null, JOptionPane.ERROR_MESSAGE);
		}
		return arrPhong;

	}
	public ArrayList<mCustomer> GetAllCustomerByRoom(String SoPhong,String trangthai) {
		ArrayList<mCustomer> arrPhong = new ArrayList<mCustomer>();
		String sql = "Select * from KhachHang where sophong =N'"+SoPhong+"'and trangthai = N'"+trangthai+"'";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				mCustomer p = new mCustomer();
				p.setFullName(rs.getString("hoten"));
				p.setGrender(rs.getString("gioitinh"));
				p.setBirthDay(rs.getString("ngaysinh")); 
				p.setPassPort(rs.getInt("socmnd"));
				p.setStatus(rs.getString("trangthai"));
				p.setRoomNumber(rs.getString("sophong"));
				p.setPhone(rs.getInt("sodienthoai"));
				p.setDateTimeFrom(rs.getTimestamp("ngayden"));
				p.setDateTimeTo(rs.getTimestamp("ngaydi"));
			
				arrPhong.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Không thể lấy danh sách khách hàng", null, JOptionPane.ERROR_MESSAGE);
		}
		return arrPhong;

	}
	public boolean UpdateKhach(int CMND, String Phong, String TrangThai) {

		String sql = "update KhachHang SET  trangthai=N'"+TrangThai+"' where sophong='"+Phong+"' and socmnd = '"+CMND+"'";
		try {
		Statement st =con.createStatement();
		return st.executeUpdate(sql)>0;
			
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Không thể cập nhật trạng thái khách hàng", null, JOptionPane.ERROR_MESSAGE);
		}
		return false;

	}
	public ArrayList<mCustomer> GetCustomers(int phonepasss) {
		ArrayList<mCustomer> arrPhong = new ArrayList<mCustomer>();
		String sql = "select * from KhachHang where socmnd LIKE N'%"+phonepasss+"%' or sodienthoai LIKE N'%"+phonepasss+"%'";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				mCustomer p = new mCustomer();
				p.setFullName(rs.getString("hoten"));
				p.setGrender(rs.getString("gioitinh"));
				p.setBirthDay(rs.getString("ngaysinh"));
				p.setPassPort(rs.getInt("socmnd"));
				p.setStatus(rs.getString("trangthai"));
				p.setEmail(rs.getString("email"));
				p.setRoomNumber(rs.getString("sophong"));
				p.setPhone(rs.getInt("sodienthoai"));
				p.setDateTimeFrom(rs.getTimestamp("ngayden"));
				p.setDateTimeTo(rs.getTimestamp("ngaydi"));
			
				arrPhong.add(p);

			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Không thể lấy danh sách khách hàng", null, JOptionPane.ERROR_MESSAGE);
		}
		return arrPhong;

	}
}
