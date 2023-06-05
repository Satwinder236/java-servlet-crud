package com.cestar.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.cestar.model.Employee;
import java.sql.*;

public class EmpDao {

	
	// create connection and then write code for inserting record
	
	
	public Connection setupConnection() {
		
		Connection con = null;
		
		String user = "root";
		
		String pwd = "";
		
		String url = "jdbc:mysql://localhost:3306/empz_db";
		
		// load the driver
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, pwd);
			
			System.out.println("Connection successful!");
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public int insertRec(Employee emp_from_servlet) throws SQLException {
		
		int status = 0;
		
		String sql = "INSERT into employee(id, name, contact, city, email) values(?,?,?,?,?)";
		
		Connection con = setupConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, emp_from_servlet.getId());
		
		pstmt.setString(2, emp_from_servlet.getName());
		
		pstmt.setString(3, emp_from_servlet.getContact());
		
		pstmt.setString(4, emp_from_servlet.getCity());
		
		pstmt.setString(5, emp_from_servlet.getEmail());
		
		System.out.println("Before execute update!");
		
		status = pstmt.executeUpdate();
		
		System.out.println("after execute update!");
		System.out.println(status);
				
		if(status > 0) {
			System.out.println("Record inserted successfully!");
		}
		else {
			System.out.println("Please try again later!");
		}
		
		return status;
	}
	
	public List<Employee> displayAllRecords() {
		
		List<Employee> emps_from_db = new ArrayList<>();
		
		String sql = "Select * from employee";
		
		Connection con = setupConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				
				// column names => id, name, contact, city, email
				
				Employee emp_from_resultset = new Employee(rs.getInt("id"), rs.getString("name"),rs.getString("contact"),rs.getString("city"),rs.getString("email"));
			
				emps_from_db.add(emp_from_resultset);
			}
			
			System.out.println(emps_from_db);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return emps_from_db;
	}
	
	
	public Employee getRecordByID(int e_id) {
		
		Employee emp = null;
		
		Connection con = setupConnection();
		
		String sql = "Select * from employee where id = ?";
		
		try {
			
			PreparedStatement ptsmt = con.prepareStatement(sql);
			
			ptsmt.setInt(1, e_id);
			
			ResultSet rs = ptsmt.executeQuery();
			
			if(rs.next()) {
				
				 emp = new Employee(rs.getInt("id"), rs.getString("name"),rs.getString("contact"),rs.getString("city"),rs.getString("email"));
			}
			
			System.out.println(emp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}
	
	
	public int updateRecord(Employee updated_emp, int old_id) {
		
		int status = 0;
		
		Connection con = setupConnection();
		
		String sql = "update employee set id = ?, name =?, contact=?, city=?, email=? where id=?";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, updated_emp.getId());
			
			pstmt.setString(2, updated_emp.getName());
			
			pstmt.setString(3, updated_emp.getContact());
			
			pstmt.setString(4, updated_emp.getCity());
			
			pstmt.setString(5, updated_emp.getEmail());
			
			pstmt.setInt(6, old_id);
			
			status = pstmt.executeUpdate();
			
			if(status > 0) {
				System.out.println("Record Updated");
			}
			else {
				System.out.println("Try Again");

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int deleteRecord(int id_from_delete_btn) {
		
		int status = 0;
		
		Connection con = setupConnection();
		
		String sql = "delete from employee where id = ?";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id_from_delete_btn);
			
			status = pstmt.executeUpdate();
			
			if(status > 0) {
				System.out.println("Record Deleted");
			}
			else {
				System.out.println("Try Again");

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	
}
