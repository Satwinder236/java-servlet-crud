<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.cestar.model.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" />

</head>
<body>


	
	
	<table class="table table-striped">
		<tbody>
			<tr>
				<th>Employee ID</th>
				<th>Name</th>
				<th>Contact</th>
				<th>City</th>
				<th>Email</th>
				<th></th>
				<th></th>
			</tr>
			<tr>
			<!--  these tags are called scriptlets and used to write java code on jsp -->
			<%
			List<Employee> emps_from_session = (List)session.getAttribute("empz");
			for(int i=0; i<emps_from_session.size(); i++){
				
				out.print("<tr>");
			
				out.print("<td>" + emps_from_session.get(i).getId() + "</td>");
				
				out.print("<td>" + emps_from_session.get(i).getName() + "</td>");
				
				out.print("<td>" + emps_from_session.get(i).getContact() + "</td>");
				
				out.print("<td>" + emps_from_session.get(i).getCity() + "</td>");
				
				out.print("<td>" + emps_from_session.get(i).getEmail() + "</td>");
				
				out.print("<td><a href='edit?e_id="+emps_from_session.get(i).getId()+"' class='btn btn-primary btn-lg' role='button'>Edit</a></td>");
				
				out.print("<td><a href='delete?e_id="+emps_from_session.get(i).getId()+"' class='btn btn-primary btn-lg' role='button'>Delete</a></td>");
				
				out.print("</tr>");
				
				
			}
			%>
			
			</tr>
		</tbody>
	</table>
</body>
</html>