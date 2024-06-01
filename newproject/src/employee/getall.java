package employee;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

public class getall {   
	
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Username = "root";
	public static final String Password = "root";
	public static final String Url = "";
	public static Connection conn;
	public static PreparedStatement pmst;
	
			
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter database name:");
		
		String Url = "jdbc:mysql://localhost:3306/" +sc.next();
		
		try {
			
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			System.out.println("Enter table name:");
			
			String sql ="select * from " + sc.next();
			
			pmst = conn.prepareStatement(sql);
			
			ResultSet rs = pmst.executeQuery();
			
			while(rs.next()) {
				System.out.println("**********");
				System.out.println("id : " + rs.getInt("id"));
				System.out.println("name : " + rs.getString("name"));
				System.out.println("email : " + rs.getString("email"));
				System.out.println("**********");
			}
			
			conn.close();
			pmst.close();
			sc.close();
			
		} catch (Exception e) {
		 e.printStackTrace();
		 
		}
	
	}

}
