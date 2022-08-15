package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public static Connection con;
	public static MyConnection instance = new MyConnection() ;
	public static Connection getConnection() {
		return con;
	}

	public static MyConnection getInstance() {
		return instance;
	}
	public MyConnection() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=sqlQLKS";
		
		String user = "sa";
		String pass = "123456";
		
		try {
			con  =DriverManager.getConnection(url,user, pass );
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
}
