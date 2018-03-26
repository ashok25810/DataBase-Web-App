package com.ashok.dbapp;

public class Emp {

	private int Id;
	private String first_Name;
	private String last_Name;
	private String Job_Type;
	private String Salary;
	public Emp(int id, String first_Name, String last_Name, String job_Type, String salary) {
		super();
		Id = id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		Job_Type = job_Type;
		Salary = salary;
	}
	
	public Emp(String first_Name, String last_Name, String job_Type, String salary) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		Job_Type = job_Type;
		Salary = salary;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getJob_Type() {
		return Job_Type;
	}
	public void setJob_Type(String job_Type) {
		Job_Type = job_Type;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}
	
	public String toString() {
		return "Employees[id="+Id+",first_Name ="+first_Name+",last_Nmae ="+last_Name+","
				+ " Job_Type ="+Job_Type+", Salary ="+Salary+"]";
		
	}
	
	
}
