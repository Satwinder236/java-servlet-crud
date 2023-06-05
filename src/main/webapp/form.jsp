<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" />
</head>
<body>
	<form action="insert"j method="get" class="col-sm-8 ms-5 mt-5">
	  <div class="mb-3 col-sm-8">
	    <label for="id" class="form-label">Employee id</label>
	    <input type="text" class="form-control" id="e_id" name="e_id">
	  </div>
	  
	  <div class="mb-3 col-sm-8">
	    <label for="e_name" class="form-label">Name</label>
	    <input type="text" class="form-control" id="e_name" name="e_name">
	  </div>
	  
	  <div class="mb-3 col-sm-8">
	    <label for="e_name" class="form-label">Contact</label>
	    <input type="text" class="form-control" id="econtact" name="econtact">
	  </div>
	  
	  <div class="mb-3 col-sm-8">
	    <label for="e_name" class="form-label">City</label>
	    <input type="text" class="form-control" id="ecity" name="ecity">
	  </div>
	  
	  <div class="mb-3 col-sm-8">
	    <label for="e_name" class="form-label">Email</label>
	    <input type="text" class="form-control" id="eemail" name="eemail">
	  </div>
	
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>