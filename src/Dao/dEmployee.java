package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.mEmployee;

public class dEmployee {
	private Connection con;
	public dEmployee() {
		con = MyConnection.getConnection();
	}
	public boolean Insert(mEmployee nv) {
		String sql = "Insert into nhanvien(hoten, gioitinh,ngaysinh,socmnd,email,quequan,sodienthoai,chucvu) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nv.getFullName());
			ps.setString(2, nv.getGender());
			ps.setString(3, nv.getBirthDay());
			ps.setInt(4, nv.getPassPort());
			ps.setString(5, nv.getEmail());
			ps.setString(6, nv.getHomeTowm());
			ps.setInt(7, nv.getPhone());
			ps.setString(8, nv.getPosition()); 
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public ArrayList<mEmployee> GetAllEmployee(){
		ArrayList<mEmployee> arrEmp = new ArrayList<mEmployee>();
		String sql = "select * from nhanvien";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				mEmployee e = new mEmployee();
				e.setId(rs.getInt(1));
				e.setFullName(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setBirthDay(rs.getString(4));
				e.setPassPort(rs.getInt(5));
				e.setEmail(rs.getString(6));
				e.setHomeTowm(rs.getString(7));
				e.setPhone(rs.getInt(8));
				e.setPosition(rs.getString(9));
				arrEmp.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrEmp;
		
	}
	public boolean Delete(int PassPort) {
		String sql = "Delete from nhanvien where socmnd =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, PassPort); 
			return ps.executeUpdate()>0; 
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Xóa không thành công", null, JOptionPane.ERROR_MESSAGE);
		}

		return false;

	}
	public boolean Update(mEmployee e){
	      
        String sql = "update nhanvien set hoten =?, gioitinh=?, ngaysinh=?, socmnd=?, email=?, quequan=?, sodienthoai=?, chucvu=? where manv = ?";
        try{
        	PreparedStatement ps = con.prepareStatement(sql);
        	ps.setString(1, e.getFullName());
        	ps.setString(2, e.getGender());
        	ps.setString(3, e.getBirthDay());
        	ps.setInt(4, e.getPassPort());
        	ps.setString(5, e.getEmail());
        	ps.setString(6, e.getHomeTowm());
        	ps.setInt(7, e.getPhone());
        	ps.setString(8, e.getPosition());
        	ps.setInt(9, e.getId());
            return ps.executeUpdate()>0;
        }catch(SQLException ex){ 
        	ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Update nhân viên không thành công !");
        }
		return false;
          
    }
	public boolean GetNhanVien(mEmployee nv){
		 boolean check = false;
	        String sql;
	            sql = "SELECT * FROM nhanvien Where socmnd = '"+nv.getPassPort()+"'";
	        try{
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()){
	            	  check = true;
	            	  nv.setFullName(rs.getString("hoten"));
	            	  nv.setPosition(rs.getString("chucvu"));
	            }
	        }catch(SQLException ex){
	            JOptionPane.showMessageDialog(null, "lỗi !");
	        }
	        return check;
	    }
	public ArrayList<mEmployee> GetAll(String name){
		ArrayList<mEmployee> arrEmp = new ArrayList<mEmployee>();
		String sql = "select * from nhanvien where hoten LIKE N'%"+name+"%'";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				mEmployee e = new mEmployee();
				e.setId(rs.getInt(1)); 
				e.setFullName(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setBirthDay(rs.getString(4));
				e.setPassPort(rs.getInt(5));
				e.setEmail(rs.getString(6)); 
				e.setHomeTowm(rs.getString(7));
				e.setPhone(rs.getInt(8));
				e.setPosition(rs.getString(9));
				arrEmp.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrEmp;
		
	}
	/*public String GetChucVu(int cmnd){
		String[] chucvu = null;
		String sql = "select chucvu from nhanvien where socmnd = '"+cmnd+"'";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
		
				chucvu= new Stringrs.getString("chucvu"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(chucvu);
		return chucvu;
		
		
	}*/
}
