package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.mBill;
import Model.mDetailBill;

public class dDetailBill {
	private Connection con;
	public dDetailBill() {
		con = MyConnection.getConnection();
	}
	public int Insert(mDetailBill ct) {
		int i = 0;
		String sql = "insert into chitietHD (mahoadon, madichvu, sl, gia) values('"+ct.getIdBill()+"','"+ct.getIdService()+"','"+ct.getQuantum()+"','"+ct.getPrice()+"')";
		try {
			Statement st = con.createStatement();
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Không thể thêm",null, JOptionPane.ERROR_MESSAGE);
		}
		return i;
 
	}
	public int UpdateChiTiet(mDetailBill ct){
        int update = 0;
        String sql = "UPDATE chitietHD SET sl += '"+ct.getQuantum()+"', gia += '"+ct.getPrice()+"' WHERE machitiet = '"+ct.getId()+"'";
        try{
            Statement st = con.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update chi tiết không thành công !");
        }
        return update;        
    }
	public mDetailBill DetailBill(String Phong, int MaDV) {
		mDetailBill ct = null;
		String sql = "Select machitiet,sl, gia from chitietHD as ct inner join hoadon as hd on ct.mahoadon = hd.mahoadon where madichvu = '"+MaDV+"' and phong = '"+Phong+"' and hd.trangthai=N'Chưa thanh toán'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				ct = new mDetailBill();
				ct.setId(rs.getInt("machitiet"));
				ct.setQuantum(rs.getInt("sl"));
				ct.setPrice(rs.getInt("gia"));
						
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		return ct;
		
	}
	public ArrayList<mDetailBill> DetailBillDByRoom(String Room) {
		ArrayList<mDetailBill> arrCT = new ArrayList<mDetailBill>();
		String sql = "Select phong,madichvu,sl, gia from chitietHD as ct inner join hoadon as hd on ct.mahoadon = hd.mahoadon  where hd.phong = '"+Room+"' and hd.trangthai =N'Chưa thanh toán'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				mBill hd = new mBill();
				hd.setRoomNumber(rs.getString("phong"));
				mDetailBill ct = new mDetailBill();
				ct.setIdService(rs.getInt("madichvu"));
				ct.setQuantum(rs.getInt("sl"));
				ct.setPrice(rs.getInt("gia"));
				arrCT.add(ct);
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		return arrCT; 
		
	}
	
}
