package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.mRoomType;

public class dRoomType {
	private Connection con;
	public dRoomType() {
		con = MyConnection.getConnection();
	}
	public ArrayList<mRoomType> GetAllLoaiPhong(){
		
		ArrayList<mRoomType> arrLoai = new ArrayList<mRoomType>();
		String sql ="Select * from loaiphong order by id";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				mRoomType lp = new mRoomType();
				lp.setId(rs.getInt("id"));
				lp.setRoomType(rs.getString("loaiphong"));
				lp.setPrice(rs.getInt("gia"));
				arrLoai.add(lp);
				 
			}
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Không thể lấy danh sách loại phòng", null, JOptionPane.ERROR_MESSAGE);
		}
		
		return arrLoai;
		
		
	}
	public ArrayList<mRoomType> GetPriceByLoai(String LoaiPhong){
		ArrayList<mRoomType> arrLoai = new ArrayList<mRoomType>();
		String sql ="select * from loaiphong where loaiphong LIKE N'%"+LoaiPhong+"%'";
		 
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				mRoomType lp = new mRoomType();
				lp.setId(rs.getInt("id"));
				lp.setRoomType(rs.getString("loaiphong"));
				lp.setPrice(rs.getInt("gia"));
				arrLoai.add(lp);
				
			}
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Không thể lấy danh sách loại phòng", "Error message", JOptionPane.ERROR_MESSAGE);
		}
		return arrLoai;
		
	}
	public boolean Insert(mRoomType lp) {

		String sql = "Insert into loaiphong(loaiphong, gia) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, lp.getRoomType());
			ps.setInt(2, lp.getPrice());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Loại phòng này đã có", null, JOptionPane.ERROR_MESSAGE);
		}
		return false;

	}
	public boolean Delete(int ID) {
		String sql = "Delete from loaiphong where id =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID); 
			return ps.executeUpdate()>0;
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Xóa không thành công", null, JOptionPane.ERROR_MESSAGE);
		}

		return false;

	}
	public boolean UpdateChiTiet(int id, String RoomType, int Price){
      
        String sql = "UPDATE loaiphong SET loaiphong = N'"+RoomType+"', gia = '"+Price+"' WHERE id = '"+id+"'";
        try{
            Statement st = con.createStatement();
            return st.executeUpdate(sql)>0;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update chi tiết không thành công !");
        }
		return false;
          
    }
}
