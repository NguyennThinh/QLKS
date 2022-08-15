package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.mListServiceUse;

public class dListServiceUse {
	private Connection con;
	public dListServiceUse() {
		con = MyConnection.getConnection();
	}
	  public ArrayList<mListServiceUse> GetDsOrder(int maHD){
		   ArrayList<mListServiceUse>   arrDs = new ArrayList<mListServiceUse>();
	        String sql;
	            sql = "Select mahoadon, ct.madichvu, tendichvu,ct.sl ,ct.gia, td.donvitinh  From chitietHD AS ct INNER JOIN DichVu AS td ON ct.madichvu = td.madichvu Where ct.mahoadon = '"+maHD+"'";
	        try{
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	         
	            while(rs.next()){
	            	mListServiceUse dv = new mListServiceUse();
	            	dv.setBillId(rs.getInt("mahoadon"));
	            	dv.setServiceName(rs.getString("tendichvu"));
	            	dv.setServiceId(rs.getInt("madichvu"));
	            	dv.setPrice(rs.getInt("gia"));
	            	dv.setQuantum(rs.getInt("sl"));
	            	dv.setUnit(rs.getString("donvitinh"));
	                arrDs.add(dv);
	           
	                
	            } 
	        }catch(SQLException ex){
	            JOptionPane.showMessageDialog(null, "Không lấy được danh sách  !");
	            ex.printStackTrace();
	        } 
	        return arrDs;        
	    }   
	  public ArrayList<mListServiceUse> GetListService(String date1, String date2, int maDV){
		   ArrayList<mListServiceUse>   arrDs = new ArrayList<mListServiceUse>();
	        String sql;
	            sql = "Select td.gia, sl, ct.madichvu, td.tendichvu From chitietHD AS ct INNER JOIN hoadon AS hd ON ct.mahoadon = hd.mahoadon INNER JOIN DichVu AS td ON td.madichvu = ct.madichvu where "
	            		+ "ngayden >= '"+date1+"' and ngaydi <= '"+date2+"' and ct.madichvu ='"+maDV+"'";
	        try{
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	         
	            while(rs.next()){
	            	mListServiceUse dv = new mListServiceUse();
	            //	dv.setMahoadon(rs.getInt("mahoadon"));
	            	dv.setServiceName(rs.getString("tendichvu"));
	            	dv.setServiceId(rs.getInt("madichvu"));
	            	dv.setPrice(rs.getInt("gia"));
	            	dv.setQuantum(rs.getInt("sl"));
	                arrDs.add(dv);
	           
	                
	            }
	        }catch(SQLException ex){
	            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
	            ex.printStackTrace();
	        } 
	        return arrDs;        
	    }  
	  
}
