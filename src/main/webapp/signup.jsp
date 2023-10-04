<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up Form</title>
<c:import url="common/header.html"/>
</head>
<body>
	<div class="container">
	<h2>Sign Up Form</h2>
	<form action="user" method="post">
	
	<input type="hidden" name="mode" value="REGISTER">
    <div >
      <label for="firstname" class="form-label">Firstname</label>
      <input type="text" name="firstname" class="form-control" id="firstname"  required="required">
      
    </div>
    
    <div class="mb-3">
      <label for="lastname" class="form-label">Lastname</label>
      <input type="text" name="lastname" class="form-control" id="lastname" required="required">
    </div>
    
    <div class="mb-3">
      <label for="email" class="form-label">Email</label>
      <input type="email" name="email"  class="form-control" id="email" required="required">
    </div>
    
    <div class="mb-3">
      <label for="password" class="form-label">Password</label>
      <input type="password" name="password" class="form-control" id="password" required="required">
    </div>
    
   
    
    <div class="mb-3 form-check">
      <input type="checkbox" name="active" value="true" class="form-check-input" id="active">
      <label class="form-check-label" for="active">*Active</label>
    </div>
    
     <div class="mb-3 form-check">
      <input type="checkbox" name="admin"  value="true" class="form-check-input" id="admin">
      <label class="form-check-label" for="admin">*Admin</label>
    </div>
    
    
    
    <button type="submit" class="btn btn-primary">Comfirm</button>
  </form>
  Already have an account?<a href="login">Login here</a>
  </div>
  <c:import url="common/footer.html"/>
</body>
</html>