package com.ashok.dbapp;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EmpControllerServlet
 */
@WebServlet("/EmpControllerServlet")
public class EmpControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDbUtil empDbUtil;
	
	@Resource(name="jdbc/atechdb")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
	//Create instance of EmpDbUtil and pass in the conn poll and datasource
		try {
		empDbUtil=new EmpDbUtil(dataSource);
		
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			String theCommand=request.getParameter("command");
			
			if(theCommand==null) {
				theCommand="LIST";
			}
		
			switch(theCommand) {
			
			case "LIST":
				listEmployees(request,response);
				break;
			
			case "LOAD":
				loadEmployee(request,response);
				break;
			case "UPDATE":
				updateEmployee(request,response);
				break;
			case "DELETE":
				deleteEmployee(request,response);
				break;
			default:
					listEmployees(request,response);
					break;
			}
			
		} 
		catch (Exception e) {
			
			throw new ServletException(e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String theCommand=request.getParameter("command");
		
		if(theCommand==null) {
			theCommand="LIST";
		}
	
		switch(theCommand) {
		case "ADD":
			try {
				addEmployees(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default:
			try {
				listEmployees(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;

		}
		
	}
	
	


	
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//Read emp info from data
		int id=Integer.parseInt(request.getParameter("id"));
		String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		String jobtype=request.getParameter("jobtype");
		String salary=request.getParameter("salary");
		
		Emp theEmployee=new Emp(id,firstName,lastName,jobtype,salary);
		
		//Perform update on db
		EmpDbUtil.updateEmployee(theEmployee);
		
		//send backk to the list emp page
		listEmployees(request,response);
		
			}


	private void listEmployees(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		
		//getStudent From DbUtil
		
		List<Emp> employees=empDbUtil.getEmp();
		
		//add students to request
		request.setAttribute("Employees_List", employees);
		
		//send to the JSp
		//response.sendRedirect("/list_Employees.jsp");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/list_Employees.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	private void addEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Read DAta from Form
		int id=Integer.parseInt(request.getParameter("id"));//beacuse it is an integer
		String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		String jobtype=request.getParameter("jobtype");
		String salary=request.getParameter("salary");
		
		//create object of emp
		Emp theEmployee=new Emp(id,firstName,lastName,jobtype,salary);
		
		//add emp to the db
		 EmpDbUtil.addEmployees(theEmployee);
		
		 response.sendRedirect(request.getContextPath() + "/EmpControllerServlet?command=LIST");
		
	}
	

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		

		// read student id from form data
		String theEmpId = request.getParameter("empId");
		
		// get student from database (db util)
		Emp theEmp = EmpDbUtil.getEmployee(theEmpId);
		
		// place student in the request attribute
		request.setAttribute("THE_EMP", theEmp);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-employees-form.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
	
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	String	theEmpId=request.getParameter("empId");
	
	Emp theEmp=EmpDbUtil.deleteEmployee(theEmpId);
	
	listEmployees(request,response);
		
	}

}
