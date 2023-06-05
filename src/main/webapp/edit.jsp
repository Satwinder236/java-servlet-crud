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

	<h2>Welcome from edit page!</h2>
	
	<%
		Employee emp_from_servlet = (Employee)session.getAttribute("emp");
	
		out.print(emp_from_servlet);
	
		
	
	%>
	
	<form action="update" method="post" class="col-sm-8 ms-5 mt-5">
	  <div class="mb-3 col-sm-8">
	    <label for="id" class="form-label">Employee id</label>
	    <input value="<%=emp_from_servlet.getId()%>" type="text" class="form-control" id="e_id" name="e_id">
	  </div>
	  
	  <div class="mb-3 col-sm-8">
	    <label for="e_name" class="form-label">Name</label>
	    <input value="<%=emp_from_servlet.getName()%>"  type="text" class="form-control" id="e_name" name="e_name">
	  </div>
	  
	  <div class="mb-3 col-sm-8">
	    <label for="e_name" class="form-label">Contact</label>
	    <input value="<%=emp_from_servlet.getContact()%>"  type="text" class="form-control" id="econtact" name="econtact">
	  </div>
	  
	  <div class="mb-3 col-sm-8">
	    <label for="e_name" class="form-label">City</label>
	    <input value="<%=emp_from_servlet.getCity()%>"  type="text" class="form-control" id="ecity" name="ecity">
	  </div>
	  
	  <div class="mb-3 col-sm-8">
	    <label for="e_name" class="form-label">Email</label>
	    <input value="<%=emp_from_servlet.getEmail()%>"  type="text" class="form-control" id="eemail" name="eemail">
	  </div>
	
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>