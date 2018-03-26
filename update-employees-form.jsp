<!DOCTYPE>
<html>
<head>
<title>Update Employee</title>

<link type="text/css" rel="stylesheet" href="css/style.css" >
<link type="text/css" rel="stylesheet" href="css/add-student-style.css" >
	
</head>

<body>

<div id="Wrapper">

<div id="Header">
<h2>Ashok Technologies Limited</h2>

</div>
</div>
																													
<div id="container">
	<h3>Update Employee</h3>
	
	<form action="EmpControllerServlet" method="GET">
	<input type="hidden" name="command" value="UPDATE" />
	<input type="hidden" name="theEmpId" value="${THE_EMP.id}" />
	
	<table>
		<tbody>
			
			<tr>
			<td><label><b>Id:</b></label></td>
 			<td><input type="number" name="id" min="1" max="99999" value="${THE_EMP.id}" /></td>
 			  *Don't Modify ID
			</tr>

	
			<tr>
			<td><label>First Name:</label></td>
			<td><input type="text" name="firstname" value="${THE_EMP.first_Name}" /></td>
			</tr>
			
			<tr>
			<td><label>Last Name:</label></td>
			<td><input type="text" name="lastname" value="${THE_EMP.last_Name}"/></td>
			</tr>
			
			<tr>
			<td><label>Job Type:</label></td>
			<td><input type="text" name="jobtype" value="${THE_EMP.job_Type}"/></td>
			</tr>
			
			<tr>
			<td><label>Salary:</label></td>
			<td><input type="text" name="salary" value="${THE_EMP.salary}"/></td>
			</tr>
			
			<tr>
			<td><label></label></td>
			<td><input type="submit" value="Save" class="Save"/></td>
			</tr>
		
		</tbody>
	</table>
	
	</form>
	
	<div style="clear: both;"></div>
	
	<p><a href="EmpControllerServlet">back to list</a></p>
	
</div>

</body>

</html>