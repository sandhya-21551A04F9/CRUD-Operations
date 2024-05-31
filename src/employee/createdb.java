package employee;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class createdb {
	
	public static void main(String[] args) {
		
		try {
//			1.loading driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			2.create a connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" ,"root" , "root");
			
			String sql ="create database sand";
			
//			3.create a statement
			PreparedStatement pmst = conn.prepareStatement(sql);
			
//			4.execute a statement
			int i = pmst.executeUpdate();
			if (i>0) {
				System.out.println("database created");
				
			} else {
				System.out.println("database not created");
			}
			
//			5.close connection
			conn.close();
			pmst.close();
			
		} catch (Exception e) {
		 e.printStackTrace();
		 
		}
	
	}

}
