package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.mBill;
import Model.mCustomer;

public class dBill {
	private Connection con;
	public dBill() {
		con = MyConnection.getConnection();
	}
	public boolean Insert(mBill hd) {
		String sql = "insert into hoadon ( phong, ngayden, ngaydi, trangthai, tongtien) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hd.getRoomNumber());
			ps.setTimestamp(2, hd.getTimeFrom());
			ps.setTimestamp(3, hd.getTimeTo());
			ps.setString(4, hd.getStatus());
			ps.setInt(5, hd.getTotalMoney());
			 return ps.executeUpdate()>0;
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Thêm hóa đơn không thành công", null, JOptionPane.ERROR_MESSAGE);
		}
		return false;
		 
		 
	}
	 public int GetMaHD(String ma){
	        String sql;
	        int mahd = 0;
	            sql = "Select mahoadon From hoadon Where phong =N'"+ma+"'";
	            
	        try{
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()){
	                mahd = rs.getInt(1);
	            
	            }
	        }catch(SQLException ex){
	            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !", null, JOptionPane.ERROR_MESSAGE);
	        }
	        return mahd;        
	    } 
	 public int GetPrice(String ma){
	        String sql;
	        int mahd = 0;
	            sql = "Select tongtien From hoadon Where phong =N'"+ma+"'";
	            
	        try{
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()){
	                mahd = rs.getInt(1);
	            
	            }
	        }catch(SQLException ex){
	            JOptionPane.showMessageDialog(null, "Không lấy được tổng tiền phòng !", null, JOptionPane.ERROR_MESSAGE);
	        }
	        return mahd;        
	    } 
		public boolean UpdateBill( String RoomNumber, int Total) {
 
			String sql = "update hoadon SET tongtien = '"+Total+"',  trangthai=N'Đã thanh toán' where phong='"+RoomNumber+"' and trangthai =N'Chưa thanh toán'";
			try {
			Statement st =con.createStatement();
			return st.executeUpdate(sql)>0;
				
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thất bại", "Error message", JOptionPane.ERROR_MESSAGE);
			}
			return false;

		}
		public boolean UpdateStatusOfBill( String RoomNumber, String Status) {

			String sql = "update hoadon SET trangthai = N'"+Status+"' where phong='"+RoomNumber+"' and trangthai =N'Đặt trước'";
			try {
			Statement st =con.createStatement();
			return st.executeUpdate(sql)>0;
				
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thất bại", "Error message", JOptionPane.ERROR_MESSAGE);
			}
			return false;

		}
		public ArrayList<mBill> GetAllBill( String date1, String date2) {
			String sql = "Select * from hoadon where ngayden >= '"+date1+"' and ngaydi <= '"+date2+"'";
			ArrayList<mBill> arrBill = new ArrayList<mBill>();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					mBill bill = new mBill();
					bill.setId(rs.getInt(1));
					bill.setRoomNumber(rs.getString(2));
					bill.setTimeFrom(rs.getTimestamp(3));
					bill.setTimeTo(rs.getTimestamp(4));
					bill.setTotalMoney(rs.getInt(6));
					arrBill.add(bill);
				}
			} catch (SQLException e) {
			
				JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn", "Error message", JOptionPane.ERROR_MESSAGE);
			}
			return arrBill;
		}
		public ArrayList<mBill> GetAllBill() {
			String sql = "Select * from hoadon ";
			ArrayList<mBill> arrBill = new ArrayList<mBill>();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					mBill bill = new mBill();
					bill.setId(rs.getInt(1));
					bill.setRoomNumber(rs.getString(2));
					bill.setTimeFrom(rs.getTimestamp(3));
					bill.setTimeTo(rs.getTimestamp(4));
					bill.setStatus(rs.getString(5));
					bill.setTotalMoney(rs.getInt(6));
					
					arrBill.add(bill);
				}
			} catch (SQLException e) {
			
				JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn", "Error message", JOptionPane.ERROR_MESSAGE);
			}
			return arrBill;
		}
}
