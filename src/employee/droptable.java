package employee;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class droptable {   
	
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Username = "root";
	public static final String Password = "root";
	public static final String Url = "";
	public static Connection conn;
	public static PreparedStatement pmst;
	
			
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter database name:");
			
			String Url = "jdbc:mysql://localhost:3306/" +sc.next();
			
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			System.out.println("Enter table name:");
			
			String sql ="drop table " + sc.next();
			
			pmst = conn.prepareStatement(sql);
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				System.out.println(" drop table succesfully");
				
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
