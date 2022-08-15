package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.mPosition;

public class dPosition {
	private Connection con;
	public dPosition() {
		con = MyConnection.getConnection();
	}
	public boolean Insert(mPosition nv) {
		String sql = "Insert into ChucVu(maChucVu, chucvu) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nv.getMaCV());
			ps.setString(2, nv.getTenCV());
	
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Chức vụ này đã có");
		}
		return false;
		
	}
	public ArrayList<mPosition> GetAll(){
		ArrayList<mPosition> arrEmp = new ArrayList<mPosition>();
		String sql = "select * from ChucVu";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				mPosition e = new mPosition();
				e.setMaCV(rs.getString(1));
				e.setTenCV(rs.getString(2));
			
				arrEmp.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrEmp;
		
	}
	public boolean Delete(String cv) {
		String sql = "Delete from ChucVu where chucvu =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cv);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Không thể chức vụ này", null, JOptionPane.ERROR_MESSAGE);
		}

		return false;

	}
}
