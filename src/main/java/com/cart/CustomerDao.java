package com.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {
	Connection con;
	PreparedStatement pstmt;
	public Customer userById(int id) {
		//List<Product> pList = new ArrayList<>();
		Customer u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "idb@123456");
			pstmt = con.prepareStatement("select * from customer where id="+id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				u = new Customer(rs.getInt(1));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public Customer userByEmailPassword(String email,String password) {
		//List<Product> pList = new ArrayList<>();
		Customer u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "idb@123456");
			//pstmt = con.prepareStatement("select * from customer where email="+email+ "and password="+password);
			pstmt = con.prepareStatement("select * from customer where email=? and password=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				u = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public void insert(Customer u) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "idb@123456");
			pstmt = con.prepareStatement("insert into customer values(?,?,?,?)");
			//this field is AI
			//pstmt.setInt(1, u.id);
			pstmt.setString(1, u.firstname);
			pstmt.setString(2, u.lastname);
			pstmt.setString(3, u.email);
			pstmt.setString(4, u.password);

	
			int n = pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
