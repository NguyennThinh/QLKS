package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.mCustomer;
import Model.mLogin;



public class Dao_Login {
	private Connection con;
	public Dao_Login() {
		con = MyConnection.getConnection();
	}
	public boolean Insert (mLogin lg) {
		String sql = "Insert into login(username, password, chucvu) values (?, ?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, lg.getUserName());
			ps.setString(2, lg.getPassWord());
			ps.setString(3, lg.getChucVu());
			return ps.executeUpdate()>0;
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại !", "Error message", JOptionPane.ERROR_MESSAGE);
		}
		return false;
		
	}
	 public mLogin GetTaiKhoan(int name, String pass){
		 mLogin td = null;
	        String sql;
	            sql = "SELECT * FROM login Where username = '"+name+"' AND password='"+pass+"'";
	        try{
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()){
	               td  = new mLogin(rs.getInt(1), rs.getString(2), rs.getString(3));
	            }
	        }catch(SQLException ex){
	            JOptionPane.showMessageDialog(null, "lỗi !");
	        }
	        return td;
	    }
	    public boolean CheckLogin(mLogin tk)
	    {
	        boolean check = false;
	        String sql;
	            sql = "Select * From login Where username = '"+tk.getUserName()+"' AND password='"+tk.getPassWord()+"'";
	        try{
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            
	            while(rs.next()){
	                check = true;
	            }
	        }catch(SQLException ex){
	            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
	        }
	        return check; 
	    } 
		public boolean DeleteLoaiByCMND(int tk) {
			String sql = "Delete from login where username = '"+tk+"'";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				 
				return ps.executeUpdate()>0;
			} catch (SQLException e) {
				
				JOptionPane.showMessageDialog(null, "Xóa không thành công", null, JOptionPane.ERROR_MESSAGE);
			}
			
			return false;

		}
		public ArrayList<mLogin> GetAll() {
			ArrayList<mLogin> arrCus = new ArrayList<mLogin>();

			String sql = "Select * from login ";

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					mLogin c = new mLogin();
					c.setUserName(rs.getInt("username"));
					c.setPassWord(rs.getString("password"));
					c.setChucVu(rs.getString("chucvu"));
					
					arrCus.add(c);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Không thể lấy danh sách tài khoản", null, JOptionPane.ERROR_MESSAGE);
			}

			return arrCus;

		}
		public boolean Update( int tk, String pass) {

			String sql = "update login SET  password='"+pass+"' where username='"+tk+"' ";
			try {
				Statement st =con.createStatement();
				return st.executeUpdate(sql)>0;
				
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Không thể cập nhật trạng thái khách hàng", null, JOptionPane.ERROR_MESSAGE);
			}
			return false;

		}
}
