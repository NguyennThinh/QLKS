package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.mRoom;

public class dRoom {
	private Connection con;

	public dRoom() {
		con = MyConnection.getConnection();
	}

	public ArrayList<mRoom> GetAllRoom() {
		ArrayList<mRoom> arrPhong = new ArrayList<mRoom>();
		String sql = "Select * from Phong order by id";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				mRoom p = new mRoom();
				p.setId(rs.getInt("id"));
				p.setRoomNumber(rs.getString("sophong"));
				p.setStatus(rs.getString("trangthai"));
				p.setRoomType(rs.getString("loaiphong"));
				p.setAmountPeople(rs.getInt("songuoio"));
				p.setPrice(rs.getInt("giaphong"));
				arrPhong.add(p);

			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Không thể lấy danh sách phòng", null, JOptionPane.ERROR_MESSAGE);
		}
		return arrPhong;

	}

	public boolean UpdateStatus(String RoomNumber, String Status) {

		String sql = "update Phong SET  trangthai=N'"+ Status +"' where sophong='" + RoomNumber + "'";
	
		try {
			Statement st = con.createStatement();
			
			return st.executeUpdate(sql) > 0;
 
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Cập nhật phòng " + RoomNumber + " không thành công", null,
					JOptionPane.ERROR_MESSAGE);
		}
		return false;

	}
	
	public boolean Insert(mRoom in) {
		String sql = "Insert into Phong ( sophong, trangthai, loaiphong, songuoio,giaphong) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, in.getRoomNumber());
			ps.setString(2, in.getStatus());
			ps.setString(3, in.getRoomType());
			ps.setInt(4, in.getAmountPeople());
			ps.setInt(5, in.getPrice());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Phòng này đã có", "Error message", JOptionPane.ERROR_MESSAGE);
		}
		return false;

	}
	public boolean DeleteRoomByID(int ID) {
		String sql = "Delete from Phong where id =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Không thể xóa phòng này", null, JOptionPane.ERROR_MESSAGE);
		}

		return false;

	}
	public int GetSoNguoi(String SoPhong) {
		String sql;
		int songuoi = 0;
		
		sql = "Select songuoio From Phong Where sophong =N'" + SoPhong + "'";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				songuoi = rs.getInt(1);
				
				
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không lấy được danh sách !", null, JOptionPane.ERROR_MESSAGE);
			
		}
		return songuoi;
	}
	public int GetRoomPrice(String SoPhong) {
		String sql;
		
		int	giaphong=0;
		sql = "Select giaphong From Phong Where sophong =N'" + SoPhong + "'";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				giaphong = rs.getInt(1);
				
				
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không lấy được danh sách !", null, JOptionPane.ERROR_MESSAGE);
			
		}
		return giaphong;
	}
	public ArrayList<mRoom> GetAllRoomByStatus(String Status) {
		ArrayList<mRoom> arrPhong = new ArrayList<mRoom>();
		String sql = "Select * from Phong where trangthai = N'"+Status+"'";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				mRoom p = new mRoom();
				p.setId(rs.getInt("id"));
				p.setRoomNumber(rs.getString("sophong"));
				p.setStatus(rs.getString("trangthai"));
				p.setRoomType(rs.getString("loaiphong"));
				p.setAmountPeople(rs.getInt("songuoio"));
				p.setPrice(rs.getInt("giaphong"));
				arrPhong.add(p);

			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Không thể lấy danh sách phòng", null, JOptionPane.ERROR_MESSAGE);
		}
		return arrPhong;

	}
	public ArrayList<mRoom> GetRoom(String Room) {
		ArrayList<mRoom> arrPhong = new ArrayList<mRoom>();
		String sql = "select * from Phong where sophong LIKE N'%"+Room+"%'";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				mRoom p = new mRoom();
				p.setId(rs.getInt("id"));
				p.setRoomNumber(rs.getString("sophong"));
				p.setStatus(rs.getString("trangthai"));
				p.setRoomType(rs.getString("loaiphong"));
				p.setAmountPeople(rs.getInt("songuoio"));
				p.setPrice(rs.getInt("giaphong"));
				arrPhong.add(p);

			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Không thể lấy danh sách phòng", null, JOptionPane.ERROR_MESSAGE);
		}
		return arrPhong;

	}
	public ArrayList<mRoom> GetAllRoomByID(int ID) {
		ArrayList<mRoom> arrPhong = new ArrayList<mRoom>();
		if (ID == 0) {
			String sql = "Select * from Phong";

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					mRoom p = new mRoom();
					p.setId(rs.getInt("id"));
					p.setRoomNumber(rs.getString("sophong"));
					p.setStatus(rs.getString("trangthai"));
					p.setRoomType(rs.getString("loaiphong"));
					p.setPrice(rs.getInt("giaphong"));
					p.setAmountPeople(rs.getInt("songuoio"));

					arrPhong.add(p);
 
				}
			} catch (SQLException e) {

				JOptionPane.showMessageDialog(null, "Không thể lấy danh sách phòng", null, JOptionPane.ERROR_MESSAGE);
			}
		}
		return arrPhong;

	}
	public boolean UpdateRoom( String Phong, String TrangThai) {
		String sql = "update Phong SET  trangthai=N'"+TrangThai+"' where sophong='"+Phong+"'";
		try {
		Statement st =con.createStatement();
		return st.executeUpdate(sql)>0;
			
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Cập nhật phòng "+Phong+" không thành công", null, JOptionPane.ERROR_MESSAGE);
		}
		return false;

	}
}
