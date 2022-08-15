package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.mService;



public class dService {
	private Connection con;
	public dService() {
		con = MyConnection.getConnection();
	}
	public ArrayList<mService> GetServiceType(){
		ArrayList<mService> arrService = new ArrayList<mService>();
		String sql = "Select DISTINCT  loaidichvu from DichVu";
		try {
			Statement st = con.createStatement();
			ResultSet rs  =st.executeQuery(sql);
			while(rs.next()) {
				mService dv = new mService();
				
				dv.setServiceType(rs.getString("loaidichvu"));
				
				arrService.add(dv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrService;
		
	}
	public ArrayList<mService> GetAllServiceByServiceType(String loaidichvu){
		ArrayList<mService> arrService = new ArrayList<mService>();
		String sql = "Select * from DichVu where loaidichvu =N'"+loaidichvu+"'";
		try {
			Statement st = con.createStatement();
			ResultSet rs  =st.executeQuery(sql);
			while(rs.next()) {
				mService dv = new mService();
				dv.setServiceType(rs.getString("loaidichvu"));
				dv.setServiceName(rs.getString("tendichvu"));
				dv.setServicePrice(rs.getInt("gia"));
				dv.setId(rs.getInt("madichvu"));
				dv.setUnit(rs.getString("donvitinh"));
				arrService.add(dv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrService;
		
	}
	   public ArrayList<mService> GetChiTietMonByMa(){
	         ArrayList<mService> arrDs = null;
	         String sql;
	             sql = "SELECT tendichvu, madichvu, loaidichvu, gia FROM DichVu where madichvu in (Select madichvu From chitietHD)";
	         try{
	             Statement st = con.createStatement();
	             ResultSet rs = st.executeQuery(sql);
	             arrDs = new ArrayList<mService>();
	             while(rs.next()){
	            	 mService order = new mService();
	                 order.setServiceName(rs.getString(1));
	                 order.setId(rs.getInt(2));
	                 order.setServiceType(rs.getString(3));
	                 order.setServicePrice(rs.getInt(4));
	                 arrDs.add(order);
	             }
	         }catch(SQLException ex){
	         }
	         return arrDs;        
	     }  
}
