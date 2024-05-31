package employee;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
// creating database in dynamic way
public class createdbdynamic {
	
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Username = "root";
	public static final String Password = "root";
	public static final String Url = "jdbc:mysql://localhost:3306/";
	public static Connection conn;
	public static PreparedStatement pmst;
	
			
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
		
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			String sql ="create database sandhya";
			
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				System.out.println("database created");
				
			} else {
				System.out.println("database not created");

			}
			conn.close();
			pmst.close();
			sc.close();
			
		} catch (Exception e) {
		 e.printStackTrace();
		 
		}
	
	}

}
