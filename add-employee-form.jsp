<!DOCTYPE>
<html>
<head>
<title>Add Employee</title>

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
	<h3>Add Employee</h3>
	
	<form action="EmpControllerServlet" method="POST">
	<input type="hidden" name="command" value="ADD" />
	
	<table>
		<tbody>
			<tr>
			<td><label><b>Id:</b></label></td>
			<td><input type="number" name="id" min="1" max="99999" /></td>
			</tr>
	
			<tr>
			<td><label>First Name:</label></td>
			<td><input type="text" name="firstname" /></td>
			</tr>
			
			<tr>
			<td><label>Last Name:</label></td>
			<td><input type="text" name="lastname" /></td>
			</tr>
			
			<tr>
			<td><label>Job Type:</label></td>
			<td><input type="text" name="jobtype" /></td>
			</tr>
			
			<tr>
			<td><label>Salary:</label></td>
			<td><input type="text" name="salary" /></td>
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