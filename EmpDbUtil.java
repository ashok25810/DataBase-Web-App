package com.ashok.dbapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class EmpDbUtil {
	
	private static DataSource dataSource;

	public EmpDbUtil(DataSource thedatasource) {
		
		dataSource=thedatasource;
	}
	
	public List<Emp> getEmp() throws Exception{
		
		List<Emp> employees=new ArrayList<>();
		
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		
		try {
			myConn=dataSource.getConnection();
			
			String sql="select * from employees order by Id";
			
			myStmt=myConn.createStatement();
			
			myRs=myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				
				int id=myRs.getInt("Id");
				String firstName=myRs.getString("first_Name");
				String lastName=myRs.getString("last_Name");
				String jobtype=myRs.getString("Job_Type");
				String salary=myRs.getString("Salary");
				
				Emp emp=new Emp(id,firstName,lastName,jobtype,salary);
				
				employees.add(emp);
		
			}
			
			return employees;
		}
		finally
		{
			close(myConn,myStmt,myRs);
			
		}
		
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try {
			
			if(myConn !=null) {
				myConn.close();;
			}
			
			if(myStmt !=null) {
				myStmt.close();;
			}
			
			if(myRs !=null) {
				myRs.close();;
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static Emp getEmployee(String theEmpId) throws Exception {
		Emp theEmp=null;
		
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		int empId;
		try {
			// convert student id to int
						empId = Integer.parseInt(theEmpId);
						
						// get connection to database
						myConn = dataSource.getConnection();
						
						// create sql to get selected student
						String sql = "select * from employees where id=?";
						
						// create prepared statement
						myStmt = myConn.prepareStatement(sql);
						
						// set params
						myStmt.setInt(1, empId);
						
						// execute statement
						myRs = myStmt.executeQuery();
						
						// retrieve data from result set row
						if (myRs.next()) {
							int id=myRs.getInt("Id");
							String firstName=myRs.getString("first_Name");
							String lastName=myRs.getString("last_Name");
							String jobtype=myRs.getString("Job_Type");
							String salary=myRs.getString("Salary");
							
							// use the studentId during construction
							theEmp=new Emp(id,firstName,lastName,jobtype,salary);
							
						}
						else {
							throw new Exception("Could not find Employee id: " + empId);
						}				
						
						return theEmp;
		
		}
		
		finally {
		close(myConn,myStmt,myRs);	
		}
	}

	public static void updateEmployee(Emp theEmployee) throws SQLException {
		
		Connection myConn=null;
		PreparedStatement myStmt=null;
		
		try {
			
			myConn=dataSource.getConnection();
			
			String sql="update employees "+
			"set Id=?,First_Name=?,Last_Name=?,Job_Type=?,Salary=? "
			+"where id=?";
			
			myStmt=myConn.prepareStatement(sql);
			
			myStmt.setInt(1, theEmployee.getId());
			myStmt.setString(2, theEmployee.getFirst_Name());
			myStmt.setString(3, theEmployee.getLast_Name());
			myStmt.setString(4, theEmployee.getJob_Type());
			myStmt.setString(5, theEmployee.getSalary());
			myStmt.setInt(6, theEmployee.getId());
			
			myStmt.execute();
			
		}
		finally {
			close(myConn, myStmt, null);
		}
	}
	

	public static void addEmployees(Emp theEmployee) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try {
		//connection to the db
		myConn = dataSource.getConnection();
		
		//create sql stmt to insert
		String sql = "insert into employees "
				   + "(Id,First_name, Last_Name, Job_Type,Salary) "
				   + "values (?, ?, ?,?,?)";
		myStmt=myConn.prepareStatement(sql);
		
		// set the param values for the student
		myStmt.setInt(1, theEmployee.getId());
		myStmt.setString(2, theEmployee.getFirst_Name());
		myStmt.setString(3, theEmployee.getLast_Name());
		myStmt.setString(4, theEmployee.getJob_Type());
		myStmt.setString(5, theEmployee.getSalary());
		
		// execute sql insert
		myStmt.execute();
		
		}
		finally {
			close(myConn,myStmt,null);
		}
	}

	public static Emp deleteEmployee(String theEmpId) throws Exception {
		
		Connection myConn=null;;
		PreparedStatement myStmt=null;;
		
		try {
			
			int id=Integer.parseInt(theEmpId);
			
			myConn=dataSource.getConnection();
			
			String sql="delete from employees where id=?";
			
			myStmt=myConn.prepareStatement(sql);
			
			myStmt.setInt(1, id);
			
			myStmt.execute();
			
			return null;
		}
		finally {
			close(myConn,myStmt,null);
		}
		
	}
}
