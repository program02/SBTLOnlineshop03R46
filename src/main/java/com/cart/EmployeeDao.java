package com.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {
	Connection con;
	PreparedStatement pstmt;
	public Employee userById(int id) {
		//List<Product> pList = new ArrayList<>();
		Employee u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "idb@123456");
			pstmt = con.prepareStatement("select * from employee where id="+id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				u = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public Employee userByEmailPassword(String email,String password) {
		//List<Product> pList = new ArrayList<>();
		Employee u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "idb@123456");
			pstmt = con.prepareStatement("select * from employee where id="+email+ "and id="+password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				u = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public void insert(Employee u) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "idb@123456");
			pstmt = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, u.id);
			pstmt.setString(2, u.name);
			pstmt.setString(3, u.email);
			pstmt.setString(4, u.password);
			pstmt.setString(5, u.designation);
			pstmt.setString(6, u.phone);
			pstmt.setDate(7, u.joindate);
	
			int n = pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
