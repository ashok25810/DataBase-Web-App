<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE>
<html>
<head>

<title>Employees List</title>

	<link type="text/css" rel="stylesheet" href="css/style.css" >
	
</head>

<body>

<div id="Wrapper">

<div id="Header">
<h2>Ashok Technologies Limited</h2>

</div>
</div>

<div id="Container">

<div id="Content">

<input type="button" value="Add Employee"
onclick="window.location.href='add-employee-form.jsp';return false"
class="add-student-button" />

<table>

<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Job Type</th>
<th>Salary</th>
<th>Action</th>
</tr>


<c:forEach var="tempEmp" items="${Employees_List}">

<tr>

	<!-- set up a link for each student update -->
		<c:url var="tempLink" value="EmpControllerServlet">
		<c:param name="command" value="LOAD" />
		<c:param name="empId" value="${tempEmp.id}" />
		</c:url>
					
		<!-- set up a link for each student update -->
		<c:url var="deleteLink" value="EmpControllerServlet">
		<c:param name="command" value="DELETE" />
		<c:param name="empId" value="${tempEmp.id}" />
		</c:url>
		
<td> ${tempEmp.id} </td>
 <td> ${tempEmp.first_Name} </td>
 <td> ${tempEmp.last_Name }  </td> 
 <td> ${tempEmp.job_Type} </td> 
 <td> ${tempEmp.salary} </td>
 <td><a href="${tempLink}">Update</a>
 		| <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false">Delete</a>
 </td>

</tr>
</c:forEach>
</table>

</div>

</div>

</body>
</html>