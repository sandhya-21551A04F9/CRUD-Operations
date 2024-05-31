package employee;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class dropdb {   
	
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Username = "root";
	public static final String Password = "root";
	public static final String Url = "";
	public static Connection conn;
	public static PreparedStatement pmst;
	
			
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			String Url = "jdbc:mysql://localhost:3306/";
			
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			System.out.println("Enter database name:");
			
			String sql ="drop database " + sc.next();
			
			pmst = conn.prepareStatement(sql);
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				System.out.println("database deleted succesfully");
				
			} else {
				System.out.println("error");

			}
			conn.close();
			pmst.close();
			sc.close();
			
		} catch (Exception e) {
		 e.printStackTrace();
		 
		}
	
	}

}
